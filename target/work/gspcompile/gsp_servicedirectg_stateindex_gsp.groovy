import com.soconcepts.servicedirect.State
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_servicedirectg_stateindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/state/index.gsp" }
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
expressionOut.print(stateInstanceCount)
printHtmlPart(10)
invokeTag('sortableColumn','g',23,['property':("id"),'title':(message(code: 'state.id.label', default: 'ID'))],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',25,['property':("state"),'title':(message(code: 'state.state.label', default: 'State'))],-1)
printHtmlPart(12)
invokeTag('message','g',27,['code':("state.country.label"),'default':("Country")],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',28,['property':("created"),'title':(message(code: 'state.created.label', default: 'Created'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',29,['property':("modified"),'title':(message(code: 'state.modified.label', default: 'Modified'))],-1)
printHtmlPart(15)
invokeTag('sortableColumn','g',31,['property':("active"),'title':(message(code: 'state.active.label', default: 'Active'))],-1)
printHtmlPart(16)
loop:{
int i = 0
for( stateInstance in (stateInstanceList) ) {
printHtmlPart(17)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(18)
expressionOut.print(fieldValue(bean: stateInstance, field: "id"))
printHtmlPart(19)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: stateInstance, field: "state"))
})
invokeTag('link','g',40,['action':("show"),'id':(stateInstance.id)],3)
printHtmlPart(19)
expressionOut.print(fieldValue(bean: stateInstance, field: "country.country"))
printHtmlPart(19)
invokeTag('formatBoolean','g',44,['boolean':(stateInstance.active)],-1)
printHtmlPart(20)
invokeTag('formatDate','g',47,['date':(stateInstance.created)],-1)
printHtmlPart(21)
invokeTag('formatDate','g',48,['date':(stateInstance.modified)],-1)
printHtmlPart(21)
createClosureForHtmlPart(22, 3)
invokeTag('link','g',49,['class':("btn-sm btn-info"),'action':("edit"),'id':(stateInstance.id)],3)
printHtmlPart(23)
createTagBody(3, {->
invokeTag('actionSubmit','g',49,['class':("btn-danger"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
})
invokeTag('form','g',49,['url':([resource:stateInstance, action:'delete']),'method':("DELETE")],3)
printHtmlPart(24)
i++
}
}
printHtmlPart(25)
invokeTag('paginate','g',55,['total':(stateInstanceCount ?: 0)],-1)
printHtmlPart(26)
})
invokeTag('captureBody','sitemesh',58,[:],1)
printHtmlPart(27)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1450202671310L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
