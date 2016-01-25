package com.soconcepts.servicedirect

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.ServiceProvider
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional
import com.soconcepts.servicedirect.ServiceProvider
import com.soconcepts.servicedirect.utils.EmailSender
import org.codehaus.groovy.grails.web.mapping.LinkGenerator

@Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
class VController {

    // Inject link generator
    LinkGenerator grailsLinkGenerator
    static allowedMethods = [sendContactUsMail: "POST"]
    
    def howitworks() { }
    
    @Transactional
    def activate() {
        System.out.println(params.id)
        System.out.println(params.code)
        def user = SecUser.findByUsername(params.id)
        
        if (user != null) {
            if (user.activationcode.equals(params.code)) {
                user.accountLocked = 0
                user.save flush:true
                flash.message = "Congrats, your account has been fully activated. You may proceed to login using the login form below. Welcome to Service Direct!"
            } else {
                flash.message = "Oops! Sorry we were unable to activate your account. Please verify the link you received in your email again or contact Customer Support."
            }
        } else {
            flash.message = "Oops! Sorry we were unable to activate your account. Please verify the link you received in your email again or contact Customer Support."
        }      
        
        redirect (controller: "login", action: "auth")
    }
    
    def findServiceProviders() {
        def lgaId = params.lga
        def subCategoryId = params.serviceSubcategory
        List<ServiceProvider> serviceProviders = ServiceProvider.getList(Long.parseLong(lgaId), Long.parseLong(subCategoryId))
        
        if (serviceProviders.size() == 0) {
            flash.noresult = "No Result. Please adjust your search criteria"
            redirect(uri: "/")
            return
        }
        
        String addressArray = ""
        String add = ""
        String lga = ""
        int i = 0
        for (ServiceProvider serviceProvider : serviceProviders) {
            if (i == 0) {
                lga = serviceProvider.user.lga.lga + "," + serviceProvider.user.lga.state.state + ", Nigeria###"
                i++
            } else {
                lga = ""
            }
            add = serviceProvider.user.address + "," + serviceProvider.user.lga.lga + "," + serviceProvider.user.lga.state.state + ", Nigeria"
            int reviewCount = 0
            double avgScore = 0
            if (serviceProvider.serviceProviderReviews != null) {
                reviewCount = serviceProvider.serviceProviderReviews.size()
                if (reviewCount > 0) {
                    avgScore = ServiceProviderReview.sumServiceProviderRatings(serviceProvider.id) / reviewCount;
                }
            }
            addressArray += lga + add + "^" + serviceProvider.user.firstname + " " + serviceProvider.user.lastname + "&lt;br /&gt;" + add + "&lt;br/&gt;Phone:&lt;a href='tel:" + serviceProvider.user.mobile + "'&gt;" + serviceProvider.user.mobile + "&lt;a/&gt;&lt;br/&gt;Email:&lt;a href='mailto:" + serviceProvider.user.username + "'&gt;" + serviceProvider.user.username + "&lt;a/&gt;&lt;br/&gt;&lt;a target='_blank' href='/servicedirectg/serviceProvider/show/" + serviceProvider.id + "'&gt;more...&lt;a/&gt;^&lt;div class=&quot;service_provider&quot;&gt;&lt;h3&gt;#abegin#" + serviceProvider.user.firstname + " " + serviceProvider.user.lastname + "#aend#&lt;/h3&gt;&lt;table width=&quot;100%&quot; border=&quot;0&quot;&gt;&lt;tr&gt;&lt;td&gt;&lt;fieldset class=&quot;rating&quot;&gt;&lt;legend&gt;" + reviewCount + " Rating(s): &lt;/legend&gt;" + "&lt;span class=&quot;stars&quot;&gt;" + avgScore + "&lt;/span&gt;&lt;input type=&quot;hidden&quot; value=&quot;" + avgScore + "&quot; id=&quot;hiddenrating&quot; /&gt;&lt;/fieldset&gt;&lt;/td&gt;&lt;td align=&quot;center&quot; valign=&quot;top&quot;&gt;#abegin1#View Details#aend1#&lt;/td&gt;&lt;/tr&gt;&lt;/table&gt;&lt;/div&gt;~"
        }
        if (addressArray.length() > 0) {
            addressArray = addressArray.substring(0, addressArray.length() - 1)
        }
        flash.addresses = addressArray
        
        System.out.println("address result :: " + addressArray)
    }

    def deals() { }
    
    def contactUs() { }
    
    def sendContactUsMail() {
        System.out.println("in here")
        System.out.println("Name :: " + params.name)
        try {
            String message = "<h1 style=\"margin: 0;padding: 0;display: block;font-family: Helvetica;font-size: 40px;font-style: normal;font-weight: bold;line-height: 125%;letter-spacing: -1px;text-align: left;color: #606060 !important;\"><span style=\"font-size:18px\"><span style=\"color:#333333\"><span style=\"font-family:georgia,times,times new roman,serif\"><span style=\"line-height:1.6em\">Dear Support</span></span></span></span></h1><p style=\"margin: 1em 0;padding: 0;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;color: #606060;font-family: Helvetica;font-size: 15px;line-height: 150%;text-align: left;\"><span style=\"color:#333333\"><span style=\"font-size:18px\"><span style=\"font-family:georgia,times,times new roman,serif\">New Contact Us Request  <br /> Name: \${name} <br /> Email: \${email} <br /> Message: \${message} <br /> Regards, <br /> \${signature}</span><br><br></span></span><br></p>";
            Map<String, String> rootMap = new HashMap<>();
            rootMap.put("name", params.name);
            rootMap.put("email", params.email);
            rootMap.put("message", params.message);
            rootMap.put("signature", "ServiceDirect Team");
            String from = "info@servicedirect.com.ng";
            String to = "info@servicedirect.com.ng";
            String subject = "New Contact Us Request!";
            String baseUrl = grailsLinkGenerator.serverBaseURL
            new EmailSender(message, rootMap, from, to, subject, baseUrl).start();
        } catch (Exception ex) {
            System.out.println("Error In COntact Us")
            ex.printStackTrace()
        }
        request.withFormat {
            form multipartForm {
                flash.message = "Your Request has been received. We will get back to you within 24 hours."
                redirect action: "contactUs"
            } 
        }
    }
}
