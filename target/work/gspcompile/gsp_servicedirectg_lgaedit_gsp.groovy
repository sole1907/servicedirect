import com.soconcepts.servicedirect.Lga
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_servicedirectg_lgaedit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/lga/edit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main_accordion")],-1)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',6,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
if(true && (flash.message)) {
printHtmlPart(4)
expressionOut.print(flash.message)
printHtmlPart(5)
}
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
createTagBody(3, {->
printHtmlPart(8)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(9)
expressionOut.print(error.field)
printHtmlPart(10)
}
printHtmlPart(11)
invokeTag('message','g',16,['error':(error)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',17,['bean':(lgaInstance),'var':("error")],3)
printHtmlPart(13)
})
invokeTag('hasErrors','g',19,['bean':(lgaInstance)],2)
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(14)
invokeTag('hiddenField','g',21,['name':("version"),'value':(lgaInstance?.version)],-1)
printHtmlPart(14)
invokeTag('render','g',22,['template':("form")],-1)
printHtmlPart(15)
invokeTag('submitButton','g',25,['name':("update"),'action':("update"),'class':("save btn btn-primary"),'value':(message(code: 'default.button.update.label', default: 'Update'))],-1)
printHtmlPart(16)
createClosureForHtmlPart(17, 3)
invokeTag('link','g',26,['class':("list btn btn-warning"),'action':("index")],3)
printHtmlPart(18)
})
invokeTag('form','g',29,['url':([resource:lgaInstance, action:'update']),'method':("PUT")],2)
printHtmlPart(19)
})
invokeTag('captureBody','sitemesh',31,[:],1)
printHtmlPart(20)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1446321790569L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
