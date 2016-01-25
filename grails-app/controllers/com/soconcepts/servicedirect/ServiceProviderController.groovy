package com.soconcepts.servicedirect


import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured
import org.codehaus.groovy.grails.web.mapping.LinkGenerator
import com.soconcepts.servicedirect.utils.UtilityMethods
import com.soconcepts.servicedirect.utils.EmailSender
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.io.InputStream
import groovy.json.JsonSlurper
import grails.converters.JSON

@Transactional(readOnly = true)
class ServiceProviderController {

    def springSecurityService
    
    // Inject link generator
    LinkGenerator grailsLinkGenerator
    static allowedMethods = [uploadPicture: "POST", newServiceProvider: "POST", serviceProviderRating: "POST", save: "POST", update: "POST", processUpload: "POST", delete: "DELETE"]

    @Secured(['ROLE_SERVICE_PROVIDER', 'ROLE_ADMIN'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ServiceProvider.list(params), model:[serviceProviderInstanceCount: ServiceProvider.count()]
    }

    @Transactional
    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def show(ServiceProvider serviceProviderInstance) {
        def user = null
        if (springSecurityService != null) {
            user = springSecurityService?.currentUser
        }
        new ProfileViews(user: user, serviceProvider: serviceProviderInstance, created: new Date()).save()
        respond serviceProviderInstance, model:[reviews: ServiceProviderReview.findAllByServiceProvider(serviceProviderInstance), totalrating: ServiceProviderReview.sumServiceProviderRatings(serviceProviderInstance.id)]
    }

    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def create() {
        respond new ServiceProvider(params)
    }
    
    @Secured(['ROLE_ADMIN'])
    def admincreate() {
        respond new ServiceProvider(params)
    }

    @Transactional
    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def save(ServiceProvider serviceProviderInstance, SecUser secUserInstance) {
        //System.out.println("Saving ...")
        if (serviceProviderInstance == null || secUserInstance == null) {
            //System.out.println("Not Found")
            notFound()
            return
        }

        /*if (secUserInstance.hasErrors()) {
        System.out.println("Has Errors")
        respond secUserInstance.errors, view:'create'
        return
        }*/
        def f = request.getFile('logo')
        def fileName = f.getOriginalFilename()
        if (fileName.length() > 0) {
            int lastIndexOfDot = fileName.lastIndexOf(".")
            fileName = fileName.substring(0, lastIndexOfDot) + new Random().nextInt(1000) + fileName.substring(lastIndexOfDot)
            //validate file or do something crazy hehehe

            //now transfer file
            def webrootDir = servletContext.getRealPath("/") //app directory
            File fileDest = new File(webrootDir,"images/uploads/" + fileName)
            f.transferTo(fileDest)
            serviceProviderInstance.picture = fileName
        }
        secUserInstance.accountLocked = 1
        secUserInstance.save flush:true
        
        SecUserSecRole.create secUserInstance, SecRole.findByAuthority('ROLE_SERVICE_PROVIDER')
        
        serviceProviderInstance.user = secUserInstance
        
        /*if (serviceProviderInstance.hasErrors()) {
        System.out.println("Has SP Errors")
        respond serviceProviderInstance.errors, view:'create'
        return
        }*/
        
        
        serviceProviderInstance.save flush:true

        try {
            String message = "<h1 style=\"margin: 0;padding: 0;display: block;font-family: Helvetica;font-size: 40px;font-style: normal;font-weight: bold;line-height: 125%;letter-spacing: -1px;text-align: left;color: #606060 !important;\"><span style=\"font-size:18px\"><span style=\"color:#333333\"><span style=\"font-family:georgia,times,times new roman,serif\"><span style=\"line-height:1.6em\">Dear \${firstname}</span></span></span></span></h1><p style=\"margin: 1em 0;padding: 0;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;color: #606060;font-family: Helvetica;font-size: 15px;line-height: 150%;text-align: left;\"><span style=\"color:#333333\"><span style=\"font-size:18px\"><span style=\"font-family:georgia,times,times new roman,serif\">Thank you for registering on Service Direct. <br /> Please click on the link below to activate your account: <br /> <br /> <a href=\"\${activationlink}\">\${activationlink}</a> <br /> If you are unable to click on the provided link, kindly copy and paste in your browser and hit the Go button. <br /> <br /> Regards, <br /> \${signature}</span><br><br></span></span><br></p>";
            Map<String, String> rootMap = new HashMap<String, String>();
            rootMap.put("firstname", secUserInstance.firstname);
            String baseUrl = grailsLinkGenerator.serverBaseURL
            String activationLink = baseUrl + "/v/activate/" + secUserInstance.username + "/" + secUserInstance.activationcode;
            System.out.println("Base Link :: " + baseUrl);
            rootMap.put("activationlink", activationLink);
            rootMap.put("signature", "ServiceDirect Team");
            String from = "info@servicedirect.com.ng";
            String to = secUserInstance.username
            String subject = "Welcome to ServiceDirect!";
            new EmailSender(message, rootMap, from, to, subject, baseUrl).start();
        } catch (Exception ex) {
            Logger.getLogger(ServceProviderController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'serviceProvider.label', default: 'ServiceProvider'), serviceProviderInstance.id])
                redirect(uri: "/")
            }
            '*' { respond serviceProviderInstance, [status: CREATED] }
        }
    }

    @Secured(['ROLE_SERVICE_PROVIDER'])
    def editProfile() {
        ServiceProvider serviceProviderInstance = ServiceProvider.findByUser(springSecurityService.currentUser)
        respond serviceProviderInstance, view:'edit'
    }
    
    @Secured(['ROLE_ADMIN'])
    def edit(ServiceProvider serviceProviderInstance) {
        respond serviceProviderInstance
    }

    @Transactional
    @Secured(['ROLE_SERVICE_PROVIDER', 'ROLE_ADMIN'])
    def update(ServiceProvider serviceProviderInstance) {
        if (serviceProviderInstance == null) {
            notFound()
            return
        }

        if (serviceProviderInstance.hasErrors()) {
            respond serviceProviderInstance.errors, view:'edit'
            System.out.println("i have errors " + serviceProviderInstance.errors)
            return
        }
        
        def f = request.getFile('logo')
        def fileName = f.getOriginalFilename()
        if (fileName.length() > 0) {
            int lastIndexOfDot = fileName.lastIndexOf(".")
            fileName = fileName.substring(0, lastIndexOfDot) + new Random().nextInt(1000) + fileName.substring(lastIndexOfDot)
            //validate file or do something crazy hehehe

            //now transfer file
            def webrootDir = servletContext.getRealPath("/") //app directory
            File fileDest = new File(webrootDir,"images/uploads/" + fileName)
            f.transferTo(fileDest)
            serviceProviderInstance.picture = fileName
        }

        Set serviceSubcategories = new HashSet();
        for (ServiceSubcategory subCategory : serviceProviderInstance.serviceSubcategories) {
            serviceSubcategories.add(subCategory)
        }
        
        com.soconcepts.servicedirect.SecUser user = serviceProviderInstance.user
        user.save()
        System.out.println(">>>>>>" + serviceProviderInstance.user.mobile)
        serviceProviderInstance.serviceSubcategories.clear()
        System.out.println("after::" + serviceSubcategories)
        serviceProviderInstance.serviceSubcategories = serviceSubcategories
        serviceProviderInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = "Profile Updated Successfully"
                def roles = springSecurityService.getPrincipal().getAuthorities()
                if (roles[0].equals("ROLE_SERVICE_PROVIDER")) {
                    redirect action: "editProfile", method: "GET"
                } else if (roles[0].equals("ROLE_ADMIN")) {
                    redirect action: "edit", method: "GET", id: serviceProviderInstance.id
                }
            }
            '*'{ respond serviceProviderInstance, [status: OK] }
        }
    }

    @Transactional
    @Secured(['ROLE_ADMIN'])
    def delete(ServiceProvider serviceProviderInstance) {

        if (serviceProviderInstance == null) {
            notFound()
            return
        }

        serviceProviderInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = "Service Provider successfully deleted"
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    @Secured(['ROLE_ADMIN'])
    def upload() {
    }
    
    @Transactional
    @Secured(['ROLE_ADMIN'])
    def processUpload() {
        def f = request.getFile('uploadfile')
        def message = "Upload Successful"
        
        InputStream inputStream;
        try {
            inputStream = f.inputStream
            //Create Workbook instance holding reference to .xlsx file
            //XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            org.apache.poi.ss.usermodel.Workbook workbook = null;
            try {
                workbook = WorkbookFactory.create(inputStream);
            } catch (InvalidFormatException ex) {
                Logger.getLogger(ServiceProvidersClientBean.class.getName()).log(Level.SEVERE, null, ex);
            }

            //Get first/desired sheet from the workbook
            //XSSFSheet sheet = workbook.getSheetAt(0);
            org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);

            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();

                com.soconcepts.servicedirect.SecUser user = new com.soconcepts.servicedirect.SecUser();
                Cell cell = row.getCell(0);
                user.address = cell.getStringCellValue();
                cell = row.getCell(1);
                user.firstname = cell.getStringCellValue();
                cell = row.getCell(2);
                user.lastname = cell.getStringCellValue();
                user.created = new Date();
                cell = row.getCell(3);
                user.username = cell.getStringCellValue();
                cell = row.getCell(4);
                user.mobile = cell.getStringCellValue();
                user.password = new Random().nextLong() + "";
                //user.setSex(bean.getSex());
                user.activationcode = UtilityMethods.getMD5("" + new Random().nextLong());
                user.active = 1;
                cell = row.getCell(5);
                user.lga = com.soconcepts.servicedirect.Lga.get((long) cell.getNumericCellValue());
                System.out.println("LGA is :: " + user.lga)
                user.save()
                System.out.println("New User is :: " + user.id)
                com.soconcepts.servicedirect.SecUserSecRole.create user, com.soconcepts.servicedirect.SecRole.findByAuthority('ROLE_SERVICE_PROVIDER')
        
                com.soconcepts.servicedirect.ServiceProvider serviceProvider = new com.soconcepts.servicedirect.ServiceProvider();
                serviceProvider.user = user
                cell = row.getCell(6);
                serviceProvider.about = cell.getStringCellValue();
                cell = row.getCell(7);
                serviceProvider.companyName = cell.getStringCellValue();
                cell = row.getCell(8);
                serviceProvider.addToServiceSubcategories(com.soconcepts.servicedirect.ServiceSubcategory.findById((int) cell.getNumericCellValue()))
                serviceProvider.save(flush:true) 
            }
            inputStream.close();
        } catch (IOException ex) {
            System.out.println("Cannot write file due to :: " + ex.getMessage());
            message = "Oops! Something unusual occured with your request. Please try again later or contact our support team."
        }
        
        request.withFormat {
            form multipartForm {
                flash.message = message
                redirect(action:"upload", method:"GET")
            }
            //'*' { respond serviceProviderInstance, [status: CREATED] }
        }
    }
    
    @Transactional
    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def serviceProviderRating(ServiceProvider serviceProviderInstance) {
        if (serviceProviderInstance == null) {
            notFound()
            return
        }

        if (params.rating == null || params.rating.equals("0")) {
            request.withFormat {
                form multipartForm {
                    flash.error = "Please ensure all fields are completed"
                    redirect(action:"show", method:"GET", id: serviceProviderInstance.id)
                }
            }
            return;
        }
        ServiceProviderReview userReview = new ServiceProviderReview();
        userReview.ratedBy = springSecurityService.currentUser
        userReview.rating = Double.parseDouble(params.rating);
        userReview.comment = params.mycomment
        userReview.serviceProvider = serviceProviderInstance
        userReview.raterName = (params.myname);
        userReview.created = new Date()
         
        userReview.save(flush:true) 
        

        request.withFormat {
            form multipartForm {
                flash.message = "Your Comment/Review was Successfully Submitted!"
                redirect(action:"show", method:"GET", id: serviceProviderInstance.id)
            }
            //'*' { respond serviceProviderInstance, [status: CREATED] }
        }
    }
    
    @Transactional
    @Secured(['ROLE_MOBILE_UPLOAD'])
    def newServiceProvider() {
        try {
            def json = new JsonSlurper().parseText(request.JSON.toString())
            SecUser user = new SecUser()
    
            user.username = json.email
            user.password = json.password
            user.lastname = json.lastname
            user.firstname = json.firstname
            user.address = json.address
            user.mobile = json.mobile
            user.lga = Lga.get(json.lgaid)
            user.accountLocked = 1
            user.save flush:true
        
            SecUserSecRole.create user, SecRole.findByAuthority('ROLE_SERVICE_PROVIDER')
        
            ServiceProvider sp = new ServiceProvider()
            sp.user = user
            sp.companyName = json.companyName
            sp.about = json.about
        
            sp = sp.save flush:true

            try {
                String message = "<h1 style=\"margin: 0;padding: 0;display: block;font-family: Helvetica;font-size: 40px;font-style: normal;font-weight: bold;line-height: 125%;letter-spacing: -1px;text-align: left;color: #606060 !important;\"><span style=\"font-size:18px\"><span style=\"color:#333333\"><span style=\"font-family:georgia,times,times new roman,serif\"><span style=\"line-height:1.6em\">Dear \${firstname}</span></span></span></span></h1><p style=\"margin: 1em 0;padding: 0;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;color: #606060;font-family: Helvetica;font-size: 15px;line-height: 150%;text-align: left;\"><span style=\"color:#333333\"><span style=\"font-size:18px\"><span style=\"font-family:georgia,times,times new roman,serif\">Thank you for registering on Service Direct. <br /> Please click on the link below to activate your account: <br /> <br /> <a href=\"\${activationlink}\">\${activationlink}</a> <br /> If you are unable to click on the provided link, kindly copy and paste in your browser and hit the Go button. <br /> <br /> Regards, <br /> \${signature}</span><br><br></span></span><br></p>";
                Map<String, String> rootMap = new HashMap<String, String>();
                rootMap.put("firstname", user.firstname);
                String baseUrl = grailsLinkGenerator.serverBaseURL
                String activationLink = baseUrl + "/v/activate/" + user.username + "/" + user.activationcode;
                System.out.println("Base Link :: " + baseUrl);
                rootMap.put("activationlink", activationLink);
                rootMap.put("signature", "ServiceDirect Team");
                String from = "info@servicedirect.com.ng";
                String to = user.username
                String subject = "Welcome to ServiceDirect!";
                new EmailSender(message, rootMap, from, to, subject, baseUrl).start();
            } catch (Exception ex) {
                Logger.getLogger(ServiceProviderController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            render(contentType: "text/json") {
                ["success":true, "id": sp.id]
            }
        } catch (Exception e) {
            e.printStackTrace();
            render(contentType: "text/json") {
                ["success":false]
            }
        }
    }
    
    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'serviceProvider.label', default: 'ServiceProvider'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
    
    @Transactional
    @Secured(['ROLE_MOBILE_UPLOAD'])
    def uploadPicture(ServiceProvider serviceProviderInstance) {
        try {
            if (serviceProviderInstance == null) {
                notFound()
                return
            }

            if (serviceProviderInstance.hasErrors()) {
                respond serviceProviderInstance.errors, view:'edit'
                System.out.println("i have errors " + serviceProviderInstance.errors)
                return
            }
        
            def f = request.getFile('logo')
            def fileName = f.getOriginalFilename()
            if (fileName.length() > 0) {
                int lastIndexOfDot = fileName.lastIndexOf(".")
                fileName = fileName.substring(0, lastIndexOfDot) + new Random().nextInt(1000) + fileName.substring(lastIndexOfDot)
                //validate file or do something crazy hehehe

                //now transfer file
                def webrootDir = servletContext.getRealPath("/") //app directory
                File fileDest = new File(webrootDir,"images/uploads/" + fileName)
                f.transferTo(fileDest)
                serviceProviderInstance.picture = fileName
            }

            serviceProviderInstance.save flush:true

            render(contentType: "text/json") {
                ["success":true]
            }
        } catch (Exception e) {
            e.printStackTrace();
            render(contentType: "text/json") {
                ["success":false]
            }
        }
    }
}
