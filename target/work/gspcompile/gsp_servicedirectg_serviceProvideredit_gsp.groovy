import com.soconcepts.servicedirect.ServiceProvider
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_servicedirectg_serviceProvideredit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/serviceProvider/edit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main_accordion")],-1)
printHtmlPart(2)
expressionOut.print(resource(dir: 'css', file: 'register.css'))
printHtmlPart(3)
expressionOut.print(resource(dir: 'css', file: 'tooltipster.css'))
printHtmlPart(4)
invokeTag('javascript','g',8,['src':("jquery.validate.min.js")],-1)
printHtmlPart(1)
invokeTag('javascript','g',9,['src':("tooltipster.js")],-1)
printHtmlPart(1)
invokeTag('javascript','g',10,['src':("register.js")],-1)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',11,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
createTagBody(3, {->
printHtmlPart(11)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(12)
expressionOut.print(error.field)
printHtmlPart(13)
}
printHtmlPart(14)
invokeTag('message','g',24,['error':(error)],-1)
printHtmlPart(15)
})
invokeTag('eachError','g',25,['bean':(serviceProviderInstance),'var':("error")],3)
printHtmlPart(16)
})
invokeTag('hasErrors','g',28,['bean':(serviceProviderInstance)],2)
printHtmlPart(9)
if(true && (serviceProviderInstance.picture)) {
printHtmlPart(17)
invokeTag('img','g',30,['uri':("/images/uploads/${serviceProviderInstance.picture}"),'width':("150"),'height':("150")],-1)
printHtmlPart(9)
}
else {
printHtmlPart(17)
invokeTag('img','g',33,['uri':("/images/provider-logo.jpg"),'width':("150"),'height':("150")],-1)
printHtmlPart(9)
}
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(17)
invokeTag('hiddenField','g',36,['name':("version"),'value':(serviceProviderInstance?.version)],-1)
printHtmlPart(18)
invokeTag('render','g',38,['template':("updateform")],-1)
printHtmlPart(19)
invokeTag('submitButton','g',41,['name':("create"),'class':("save"),'value':(message(code: 'default.button.update.label', default: 'Update'))],-1)
printHtmlPart(20)
})
invokeTag('form','g',45,['url':([resource:serviceProviderInstance, action:'update']),'method':("POST"),'id':("registerForm"),'enctype':("multipart/form-data")],2)
printHtmlPart(21)
})
invokeTag('captureBody','sitemesh',47,[:],1)
printHtmlPart(22)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1445885678592L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
