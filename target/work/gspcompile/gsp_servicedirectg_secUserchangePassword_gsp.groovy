import com.soconcepts.servicedirect.SecUser
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_servicedirectg_secUserchangePassword_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/secUser/changePassword.gsp" }
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
invokeTag('javascript','g',10,['src':("registeruser.js")],-1)
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
invokeTag('message','g',25,['error':(error)],-1)
printHtmlPart(15)
})
invokeTag('eachError','g',26,['bean':(secUserInstance),'var':("error")],3)
printHtmlPart(16)
})
invokeTag('hasErrors','g',29,['bean':(secUserInstance)],2)
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(17)
invokeTag('hiddenField','g',31,['name':("version"),'value':(secUserInstance?.version)],-1)
printHtmlPart(18)
invokeTag('render','g',33,['template':("passwordform")],-1)
printHtmlPart(19)
invokeTag('submitButton','g',36,['name':("create"),'class':("save"),'value':(message(code: 'default.button.update.label', default: 'Update'))],-1)
printHtmlPart(20)
})
invokeTag('form','g',40,['url':([resource:secUserInstance, action:'updatePassword']),'method':("PUT"),'id':("registeruserForm")],2)
printHtmlPart(21)
})
invokeTag('captureBody','sitemesh',42,[:],1)
printHtmlPart(22)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1445784866025L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
