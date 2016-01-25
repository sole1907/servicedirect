import com.soconcepts.servicedirect.SecUser
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_servicedirectg_secUser_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/secUser/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: secUserInstance, field: 'firstname', 'error'))
printHtmlPart(1)
invokeTag('message','g',5,['code':("secUser.firstname.label"),'default':("First Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',8,['class':("each_input"),'name':("firstname"),'maxlength':("45"),'required':(""),'value':(secUserInstance?.firstname)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: secUserInstance, field: 'lastname', 'error'))
printHtmlPart(4)
invokeTag('message','g',14,['code':("secUser.lastname.label"),'default':("Last Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',17,['class':("each_input"),'name':("lastname"),'maxlength':("45"),'required':(""),'value':(secUserInstance?.lastname)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: secUserInstance, field: 'sex', 'error'))
printHtmlPart(5)
invokeTag('message','g',23,['code':("secUser.sex.label"),'default':("Gender")],-1)
printHtmlPart(2)
invokeTag('select','g',26,['class':("each_input"),'noSelection':(['':'Select your Gender ...']),'name':("sex"),'from':(['Female','Male']),'required':(""),'value':(secUserInstance?.sex)],-1)
printHtmlPart(6)
invokeTag('message','g',32,['code':("state.label"),'default':("State of Residence")],-1)
printHtmlPart(2)
invokeTag('select','g',35,['id':("state"),'class':("many-to-one"),'name':("state.id"),'noSelection':(['':'Select State of Residence ...']),'from':(com.soconcepts.servicedirect.State.list()),'optionKey':("id"),'required':(""),'optionValue':("state"),'value':(secUserInstance?.lga?.state?.id)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: secUserInstance, field: 'lga', 'error'))
printHtmlPart(7)
invokeTag('message','g',41,['code':("secUser.lga.label"),'default':("LGA")],-1)
printHtmlPart(2)
invokeTag('select','g',44,['id':("lga"),'class':("many-to-one"),'noSelection':(['':'Select LGA ...']),'name':("lga.id"),'from':(com.soconcepts.servicedirect.Lga.stateLgasByStateId(secUserInstance?.lga?.state?.id)),'optionKey':("id"),'optionValue':("lga"),'required':(""),'value':(secUserInstance?.lga?.id)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: secUserInstance, field: 'address', 'error'))
printHtmlPart(8)
invokeTag('message','g',50,['code':("secUser.address.label"),'default':("Address")],-1)
printHtmlPart(2)
invokeTag('textArea','g',53,['class':("each_input"),'name':("address"),'cols':("40"),'rows':("5"),'maxlength':("255"),'required':(""),'value':(secUserInstance?.address)],-1)
printHtmlPart(9)
if(true && (create)) {
printHtmlPart(10)
expressionOut.print(hasErrors(bean: secUserInstance, field: 'username', 'error'))
printHtmlPart(11)
invokeTag('message','g',60,['code':("secUser.username.label"),'default':("Email Address")],-1)
printHtmlPart(12)
invokeTag('field','g',63,['type':("email"),'class':("each_input"),'name':("username"),'required':(""),'value':(secUserInstance?.username)],-1)
printHtmlPart(13)
}
printHtmlPart(14)
expressionOut.print(hasErrors(bean: secUserInstance, field: 'mobile', 'error'))
printHtmlPart(15)
invokeTag('message','g',69,['code':("secUser.mobile.label"),'default':("Phone Number")],-1)
printHtmlPart(2)
invokeTag('textField','g',72,['class':("each_input"),'name':("mobile"),'required':(""),'value':(secUserInstance?.mobile)],-1)
printHtmlPart(9)
if(true && (create)) {
printHtmlPart(10)
expressionOut.print(hasErrors(bean: secUserInstance, field: 'password', 'error'))
printHtmlPart(16)
invokeTag('message','g',79,['code':("secUser.password.label"),'default':("Password")],-1)
printHtmlPart(12)
invokeTag('passwordField','g',82,['class':("each_input"),'name':("password"),'required':(""),'value':(secUserInstance?.password)],-1)
printHtmlPart(17)
expressionOut.print(hasErrors(bean: secUserInstance, field: 'password', 'error'))
printHtmlPart(18)
invokeTag('message','g',88,['code':("secUser.password.label"),'default':("Confirm Password")],-1)
printHtmlPart(12)
invokeTag('passwordField','g',91,['class':("each_input"),'name':("password_again"),'required':("")],-1)
printHtmlPart(13)
}
printHtmlPart(19)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1445784719862L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
