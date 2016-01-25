import com.soconcepts.servicedirect.SecUser
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_servicedirectg_secUser_passwordform_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/secUser/_passwordform.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: secUserInstance, field: 'password', 'error'))
printHtmlPart(1)
invokeTag('message','g',5,['code':("secUser.newpassword.label"),'default':("New Password")],-1)
printHtmlPart(2)
invokeTag('passwordField','g',8,['class':("each_input"),'name':("password"),'required':(""),'value':(secUserInstance?.password)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: secUserInstance, field: 'password', 'error'))
printHtmlPart(4)
invokeTag('message','g',14,['code':("secUser.password.label"),'default':("Confirm Password")],-1)
printHtmlPart(2)
invokeTag('passwordField','g',17,['class':("each_input"),'name':("password_again"),'required':("")],-1)
printHtmlPart(5)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1445784977412L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
