import com.soconcepts.servicedirect.SecUser
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_servicedirectg_secUserindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/secUser/index.gsp" }
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
invokeTag('link','g',11,['class':("create btn btn-primary"),'action':("admincreate")],2)
printHtmlPart(6)
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
expressionOut.print(secUserInstanceCount)
printHtmlPart(10)
invokeTag('message','g',24,['code':("secUser.name.label"),'default':("Name")],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',25,['property':("sex"),'title':(message(code: 'secUser.sex.label', default: 'Sex'))],-1)
printHtmlPart(12)
invokeTag('sortableColumn','g',26,['property':("address"),'title':(message(code: 'secUser.address.label', default: 'Address'))],-1)
printHtmlPart(13)
invokeTag('message','g',27,['code':("secUser.lga.label"),'default':("LGA")],-1)
printHtmlPart(14)
invokeTag('message','g',28,['code':("secUser.state.label"),'default':("State")],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',29,['property':("email"),'title':(message(code: 'secUser.email.label', default: 'Email'))],-1)
printHtmlPart(12)
invokeTag('sortableColumn','g',30,['property':("mobile"),'title':(message(code: 'secUser.mobile.label', default: 'Mobile'))],-1)
printHtmlPart(12)
invokeTag('sortableColumn','g',31,['property':("active"),'title':(message(code: 'secUser.active.label', default: 'Active'))],-1)
printHtmlPart(13)
invokeTag('message','g',32,['code':("secUser.created.label"),'default':("Created")],-1)
printHtmlPart(14)
invokeTag('message','g',33,['code':("secUser.modified.label"),'default':("Modified")],-1)
printHtmlPart(15)
loop:{
int i = 0
for( secUserInstance in (secUserInstanceList) ) {
printHtmlPart(16)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(17)
expressionOut.print(fieldValue(bean: secUserInstance, field: "firstname"))
printHtmlPart(18)
expressionOut.print(fieldValue(bean: secUserInstance, field: "lastname"))
printHtmlPart(19)
expressionOut.print(fieldValue(bean: secUserInstance, field: "sex"))
printHtmlPart(19)
expressionOut.print(fieldValue(bean: secUserInstance, field: "address"))
printHtmlPart(19)
expressionOut.print(fieldValue(bean: secUserInstance, field: "lga.lga"))
printHtmlPart(19)
expressionOut.print(fieldValue(bean: secUserInstance, field: "lga.state.state"))
printHtmlPart(19)
expressionOut.print(fieldValue(bean: secUserInstance, field: "username"))
printHtmlPart(19)
expressionOut.print(fieldValue(bean: secUserInstance, field: "mobile"))
printHtmlPart(19)
expressionOut.print(fieldValue(bean: secUserInstance, field: "active"))
printHtmlPart(19)
expressionOut.print(fieldValue(bean: secUserInstance, field: "created"))
printHtmlPart(19)
expressionOut.print(fieldValue(bean: secUserInstance, field: "modified"))
printHtmlPart(19)
createClosureForHtmlPart(20, 3)
invokeTag('link','g',50,['class':("btn-sm btn-info"),'action':("edit"),'id':(secUserInstance.id)],3)
printHtmlPart(18)
createTagBody(3, {->
invokeTag('actionSubmit','g',50,['class':("btn-danger"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
})
invokeTag('form','g',50,['url':([resource:secUserInstance, action:'delete']),'method':("DELETE")],3)
printHtmlPart(21)
i++
}
}
printHtmlPart(22)
invokeTag('paginate','g',58,['total':(secUserInstanceCount ?: 0)],-1)
printHtmlPart(23)
})
invokeTag('captureBody','sitemesh',61,[:],1)
printHtmlPart(24)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1450202563697L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
