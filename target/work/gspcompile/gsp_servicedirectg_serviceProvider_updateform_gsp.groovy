import com.soconcepts.servicedirect.ServiceProvider
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_servicedirectg_serviceProvider_updateform_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/serviceProvider/_updateform.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: secUserInstance, field: 'firstname', 'error'))
printHtmlPart(1)
invokeTag('message','g',5,['code':("secUser.firstname.label"),'default':("First Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',8,['class':("each_input"),'name':("user.firstname"),'maxlength':("45"),'required':(""),'value':(serviceProviderInstance?.user?.firstname)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: secUserInstance, field: 'lastname', 'error'))
printHtmlPart(4)
invokeTag('message','g',14,['code':("secUser.lastname.label"),'default':("Last Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',17,['class':("each_input"),'name':("user.lastname"),'maxlength':("45"),'required':(""),'value':(serviceProviderInstance?.user?.lastname)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: serviceProviderInstance, field: 'companyName', 'error'))
printHtmlPart(5)
invokeTag('message','g',23,['code':("serviceProvider.companyName.label"),'default':("Company Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',26,['class':("each_input"),'name':("companyName"),'required':(""),'value':(serviceProviderInstance?.companyName)],-1)
printHtmlPart(6)
invokeTag('message','g',31,['code':("state.label"),'default':("State of Residence")],-1)
printHtmlPart(2)
invokeTag('select','g',34,['id':("state"),'class':("many-to-one"),'name':("state.id"),'noSelection':(['':'Select State of Residence ...']),'from':(com.soconcepts.servicedirect.State.list()),'optionKey':("id"),'required':(""),'optionValue':("state"),'value':(serviceProviderInstance?.user?.lga?.state?.id)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: secUserInstance, field: 'lga', 'error'))
printHtmlPart(7)
invokeTag('message','g',40,['code':("secUser.lga.label"),'default':("LGA")],-1)
printHtmlPart(2)
invokeTag('select','g',43,['id':("lga"),'class':("many-to-one"),'noSelection':(['':'Select LGA ...']),'name':("user.lga.id"),'from':(com.soconcepts.servicedirect.Lga.stateLgasByStateId(serviceProviderInstance?.user?.lga?.state?.id)),'optionKey':("id"),'optionValue':("lga"),'required':(""),'value':(serviceProviderInstance?.user?.lga?.id)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: secUserInstance, field: 'address', 'error'))
printHtmlPart(8)
invokeTag('message','g',49,['code':("serviceProvider.address.label"),'default':("Business Address")],-1)
printHtmlPart(2)
invokeTag('textArea','g',52,['class':("each_input"),'name':("user.address"),'cols':("40"),'rows':("5"),'maxlength':("255"),'required':(""),'value':(serviceProviderInstance?.user?.address)],-1)
printHtmlPart(9)
invokeTag('message','g',58,['code':("category.label"),'default':("Select Company Category")],-1)
printHtmlPart(2)
invokeTag('select','g',61,['id':("category"),'class':("many-to-one"),'name':("category.id"),'noSelection':(['':'Select your Company Category ...']),'from':(com.soconcepts.servicedirect.ServiceCategory.list()),'optionKey':("id"),'required':(""),'optionValue':("category"),'value':(serviceProviderInstance?.serviceSubcategories?.first()?.serviceCategory?.id)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: serviceProviderInstance, field: 'serviceSubcategories', 'error'))
printHtmlPart(10)
invokeTag('message','g',67,['code':("serviceProvider.serviceSubcategories.label"),'default':("Select the Service(s) you Provide (Ctrl + Click to select multiple options)")],-1)
printHtmlPart(11)
invokeTag('select','g',70,['id':("subcategory"),'style':("height: auto;"),'noSelection':(['':'Select Services you Provide ...']),'name':("serviceSubcategories"),'from':(com.soconcepts.servicedirect.ServiceSubcategory.categorySubsByCatId(serviceProviderInstance?.serviceSubcategories?.first()?.serviceCategory?.id)),'multiple':("multiple"),'optionKey':("id"),'size':("7"),'value':(serviceProviderInstance?.serviceSubcategories*.id),'optionValue':("subcategory"),'class':("many-to-many")],-1)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: serviceProviderInstance, field: 'about', 'error'))
printHtmlPart(13)
invokeTag('message','g',75,['code':("serviceProvider.about.label"),'default':("About your Company (Max of 200 characters)")],-1)
printHtmlPart(14)
invokeTag('textArea','g',77,['class':("each_input"),'name':("about"),'required':(""),'value':(serviceProviderInstance?.about),'maxlength':("200")],-1)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: secUserInstance, field: 'mobile', 'error'))
printHtmlPart(15)
invokeTag('message','g',82,['code':("secUser.mobile.label"),'default':("Phone Number")],-1)
printHtmlPart(2)
invokeTag('textField','g',85,['class':("each_input"),'name':("user.mobile"),'required':(""),'value':(serviceProviderInstance?.user?.mobile)],-1)
printHtmlPart(16)
invokeTag('message','g',91,['code':("serviceProvider.logo.label"),'default':("Logo (Size: 150px x 150px)")],-1)
printHtmlPart(17)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1445886902618L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
