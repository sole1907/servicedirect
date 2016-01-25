import com.soconcepts.servicedirect.ServiceProvider
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_servicedirectg_serviceProviderindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/serviceProvider/index.gsp" }
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
expressionOut.print(serviceProviderInstanceCount)
printHtmlPart(10)
invokeTag('sortableColumn','g',23,['property':("companyName"),'title':(message(code: 'serviceProvider.companyName.label', default: 'Company Name'))],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',24,['property':("about"),'title':(message(code: 'serviceProvider.about.label', default: 'About'))],-1)
printHtmlPart(12)
invokeTag('message','g',25,['code':("serviceProvider.user.address.label"),'default':("Address")],-1)
printHtmlPart(13)
invokeTag('message','g',26,['code':("serviceProvider.user.lga.label"),'default':("LGA")],-1)
printHtmlPart(13)
invokeTag('message','g',27,['code':("serviceProvider.user.state.label"),'default':("State")],-1)
printHtmlPart(13)
invokeTag('message','g',28,['code':("serviceProvider.user.email.label"),'default':("Email")],-1)
printHtmlPart(13)
invokeTag('message','g',29,['code':("serviceProvider.user.mobile.label"),'default':("Mobile")],-1)
printHtmlPart(13)
invokeTag('message','g',30,['code':("serviceProvider.user.name.label"),'default':("Name")],-1)
printHtmlPart(13)
invokeTag('message','g',31,['code':("serviceProvider.user.active.label"),'default':("Active")],-1)
printHtmlPart(13)
invokeTag('message','g',32,['code':("serviceProvider.user.created.label"),'default':("Created")],-1)
printHtmlPart(13)
invokeTag('message','g',33,['code':("serviceProvider.modified.label"),'default':("Modified")],-1)
printHtmlPart(14)
loop:{
int i = 0
for( serviceProviderInstance in (serviceProviderInstanceList) ) {
printHtmlPart(15)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(16)
expressionOut.print(fieldValue(bean: serviceProviderInstance, field: "companyName"))
printHtmlPart(17)
expressionOut.print(fieldValue(bean: serviceProviderInstance, field: "about"))
printHtmlPart(17)
expressionOut.print(fieldValue(bean: serviceProviderInstance, field: "user.address"))
printHtmlPart(17)
expressionOut.print(fieldValue(bean: serviceProviderInstance, field: "user.lga.lga"))
printHtmlPart(17)
expressionOut.print(fieldValue(bean: serviceProviderInstance, field: "user.lga.state.state"))
printHtmlPart(17)
expressionOut.print(fieldValue(bean: serviceProviderInstance, field: "user.username"))
printHtmlPart(17)
expressionOut.print(fieldValue(bean: serviceProviderInstance, field: "user.mobile"))
printHtmlPart(17)
expressionOut.print(fieldValue(bean: serviceProviderInstance, field: "user.firstname"))
printHtmlPart(18)
expressionOut.print(fieldValue(bean: serviceProviderInstance, field: "user.lastname"))
printHtmlPart(17)
expressionOut.print(fieldValue(bean: serviceProviderInstance, field: "user.active"))
printHtmlPart(17)
expressionOut.print(fieldValue(bean: serviceProviderInstance, field: "user.created"))
printHtmlPart(17)
expressionOut.print(fieldValue(bean: serviceProviderInstance, field: "modified"))
printHtmlPart(17)
createClosureForHtmlPart(19, 3)
invokeTag('link','g',51,['class':("btn-sm btn-info"),'action':("edit"),'id':(serviceProviderInstance.id)],3)
printHtmlPart(18)
createTagBody(3, {->
invokeTag('actionSubmit','g',51,['class':("btn-danger"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
})
invokeTag('form','g',51,['url':([resource:serviceProviderInstance, action:'delete']),'method':("DELETE")],3)
printHtmlPart(20)
i++
}
}
printHtmlPart(21)
invokeTag('paginate','g',58,['total':(serviceProviderInstanceCount ?: 0)],-1)
printHtmlPart(22)
})
invokeTag('captureBody','sitemesh',61,[:],1)
printHtmlPart(23)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1450202527129L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
