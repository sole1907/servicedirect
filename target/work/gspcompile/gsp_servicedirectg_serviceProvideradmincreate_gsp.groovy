import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_servicedirectg_serviceProvideradmincreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/serviceProvider/admincreate.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main_accordion")],-1)
printHtmlPart(2)
expressionOut.print(resource(dir: 'css', file: 'register.css'))
printHtmlPart(3)
expressionOut.print(resource(dir: 'css', file: 'tooltipster.css'))
printHtmlPart(4)
invokeTag('javascript','g',7,['src':("jquery.validate.min.js")],-1)
printHtmlPart(1)
invokeTag('javascript','g',8,['src':("tooltipster.js")],-1)
printHtmlPart(1)
invokeTag('javascript','g',9,['src':("register.js")],-1)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',10,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
invokeTag('message','g',44,['code':("default.form.instruction")],-1)
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
createTagBody(3, {->
printHtmlPart(12)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(13)
expressionOut.print(error.field)
printHtmlPart(14)
}
printHtmlPart(15)
invokeTag('message','g',54,['error':(error)],-1)
printHtmlPart(16)
})
invokeTag('eachError','g',55,['bean':(secUserInstance),'var':("error")],3)
printHtmlPart(17)
})
invokeTag('hasErrors','g',58,['bean':(secUserInstance)],2)
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
createTagBody(3, {->
printHtmlPart(12)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(13)
expressionOut.print(error.field)
printHtmlPart(14)
}
printHtmlPart(15)
invokeTag('message','g',63,['error':(error)],-1)
printHtmlPart(16)
})
invokeTag('eachError','g',64,['bean':(serviceProviderInstance),'var':("error")],3)
printHtmlPart(17)
})
invokeTag('hasErrors','g',67,['bean':(serviceProviderInstance)],2)
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(18)
invokeTag('render','g',70,['template':("form")],-1)
printHtmlPart(19)
invokeTag('submitButton','g',74,['name':("create"),'class':("save"),'value':(message(code: 'default.button.submit.label', default: 'Submit'))],-1)
printHtmlPart(20)
})
invokeTag('form','g',78,['url':([resource:serviceProviderInstance, action:'save']),'enctype':("multipart/form-data"),'id':("registerForm")],2)
printHtmlPart(21)
})
invokeTag('captureBody','sitemesh',97,[:],1)
printHtmlPart(22)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1446395686015L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
