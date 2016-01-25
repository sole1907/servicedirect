package com.soconcepts.servicedirect

import grails.plugin.springsecurity.annotation.Secured
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import com.soconcepts.servicedirect.utils.EmailSender
import org.codehaus.groovy.grails.web.mapping.LinkGenerator

@Transactional(readOnly = true)
@Secured(["ROLE_USER","ROLE_ADMIN"])
class SecUserController {

    def springSecurityService
    // Inject link generator
    LinkGenerator grailsLinkGenerator
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond SecUser.list(params), model:[secUserInstanceCount: SecUser.count()]
    }

    /*def show(SecUser secUserInstance) {
        respond secUserInstance
    }*/

    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def create() {
        respond new SecUser(params)
    }

    @Transactional
    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def save(SecUser secUserInstance) {
        if (secUserInstance == null) {
            notFound()
            return
        }

        if (secUserInstance.hasErrors()) {
            respond secUserInstance.errors, view:'create'
            return
        }

        secUserInstance.accountLocked = 1
        secUserInstance.save flush:true
        
        SecUserSecRole.create secUserInstance, SecRole.findByAuthority('ROLE_USER')

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
            ex.printStackTrace()
            //Logger.getLogger(SecUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'secUser.label', default: 'SecUser'), secUserInstance.id])
                redirect(uri: "/")
            }
            '*' { respond secUserInstance, [status: CREATED] }
        }
    }

    @Secured(['ROLE_ADMIN'])
    def edit(SecUser secUserInstance) {
        respond secUserInstance
    }

    @Secured(["ROLE_USER"])
    def editProfile() {
        def secUserInstance = springSecurityService.currentUser
        respond secUserInstance, view:'edit'
    }
  
    @Transactional
    def update(SecUser secUserInstance) {
        if (secUserInstance == null) {
            notFound()
            return
        }

        if (secUserInstance.hasErrors()) {
            respond secUserInstance.errors, view:'edit'
            return
        }

        secUserInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = "Profile Updated Successfully"//message(code: 'default.updated.message', args: [message(code: 'ServiceProvider.label', default: 'ServiceProvider'), serviceProviderInstance.id])
                def roles = springSecurityService.getPrincipal().getAuthorities()
                if (roles[0].equals("ROLE_USER")) {
                    redirect action: "editProfile", method: "GET"
                } else if (roles[0].equals("ROLE_ADMIN")) {
                    redirect action: "edit", method: "GET", id: secUserInstance.id
                }
            }
            '*'{ respond secUserInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(SecUser secUserInstance) {

        if (secUserInstance == null) {
            notFound()
            return
        }

        secUserInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'SecUser.label', default: 'SecUser'), secUserInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'secUser.label', default: 'SecUser'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
