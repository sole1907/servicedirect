import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_servicedirectg_loginauth_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/login/auth.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
expressionOut.print(resource(dir: 'css', file: 'login.css'))
printHtmlPart(3)
expressionOut.print(resource(dir: 'css', file: 'tooltipster.css'))
printHtmlPart(4)
invokeTag('javascript','g',7,['src':("jquery.validate.min.js")],-1)
printHtmlPart(1)
invokeTag('javascript','g',8,['src':("tooltipster.js")],-1)
printHtmlPart(1)
invokeTag('javascript','g',9,['src':("login.js")],-1)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',10,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
invokeTag('img','g',49,['uri':("/images/GetTheBestService.png"),'alt':("Get the best service")],-1)
printHtmlPart(10)
expressionOut.print(resource(file: 'j_spring_security_check'))
printHtmlPart(11)
invokeTag('submitButton','g',74,['name':("login"),'value':("Sign In"),'class':("btn-oval btn-yellow")],-1)
printHtmlPart(12)
expressionOut.print(createLink(controller: 'secUser', action: 'create'))
printHtmlPart(13)
expressionOut.print(createLink(controller: 'secUser', action: 'forgotPassword'))
printHtmlPart(14)
})
invokeTag('captureBody','sitemesh',122,[:],1)
printHtmlPart(15)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1447098999660L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
