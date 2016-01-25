import com.soconcepts.servicedirect.Lga
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_servicedirectg_lgaindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/lga/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main_accordion")],-1)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createClosureForHtmlPart(5, 2)
invokeTag('link','g',11,['class':("create btn btn-primary"),'action':("create")],2)
printHtmlPart(6)
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
expressionOut.print(lgaInstanceCount)
printHtmlPart(10)
invokeTag('sortableColumn','g',23,['property':("id"),'title':(message(code: 'lga.id.label', default: 'ID'))],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',25,['property':("lga"),'title':(message(code: 'lga.lga.label', default: 'Lga'))],-1)
printHtmlPart(12)
invokeTag('message','g',26,['code':("lga.state.label"),'default':("State")],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',28,['property':("active"),'title':(message(code: 'lga.active.label', default: 'Active'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',30,['property':("created"),'title':(message(code: 'lga.created.label', default: 'Created'))],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',31,['property':("modified"),'title':(message(code: 'lga.modified.label', default: 'Modified'))],-1)
printHtmlPart(16)
loop:{
int i = 0
for( lgaInstance in (lgaInstanceList) ) {
printHtmlPart(17)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(18)
expressionOut.print(fieldValue(bean: lgaInstance, field: "id"))
printHtmlPart(19)
expressionOut.print(fieldValue(bean: lgaInstance, field: "lga"))
printHtmlPart(19)
expressionOut.print(fieldValue(bean: lgaInstance, field: "state.state"))
printHtmlPart(20)
invokeTag('formatBoolean','g',42,['boolean':(lgaInstance.active)],-1)
printHtmlPart(20)
invokeTag('formatDate','g',44,['date':(lgaInstance.created)],-1)
printHtmlPart(19)
invokeTag('formatDate','g',45,['date':(lgaInstance.modified)],-1)
printHtmlPart(19)
createClosureForHtmlPart(21, 3)
invokeTag('link','g',46,['class':("btn-sm btn-info"),'action':("edit"),'id':(lgaInstance.id)],3)
printHtmlPart(22)
createTagBody(3, {->
invokeTag('actionSubmit','g',46,['class':("btn-danger"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
})
invokeTag('form','g',46,['url':([resource:lgaInstance, action:'delete']),'method':("DELETE")],3)
printHtmlPart(23)
i++
}
}
printHtmlPart(24)
invokeTag('paginate','g',52,['total':(lgaInstanceCount ?: 0)],-1)
printHtmlPart(25)
})
invokeTag('captureBody','sitemesh',55,[:],1)
printHtmlPart(26)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1450202700284L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
