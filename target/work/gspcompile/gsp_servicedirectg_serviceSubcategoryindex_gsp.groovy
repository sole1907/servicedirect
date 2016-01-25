import com.soconcepts.servicedirect.ServiceSubcategory
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_servicedirectg_serviceSubcategoryindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/serviceSubcategory/index.gsp" }
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
expressionOut.print(serviceSubcategoryInstanceCount)
printHtmlPart(10)
invokeTag('sortableColumn','g',23,['property':("id"),'title':(message(code: 'serviceSubcategory.id.label', default: 'ID'))],-1)
printHtmlPart(11)
invokeTag('sortableColumn','g',24,['property':("subcategory"),'title':(message(code: 'serviceSubcategory.subcategory.label', default: 'Subcategory'))],-1)
printHtmlPart(12)
invokeTag('message','g',26,['code':("serviceSubcategory.serviceCategory.label"),'default':("Service Category")],-1)
printHtmlPart(13)
invokeTag('sortableColumn','g',28,['property':("active"),'title':(message(code: 'serviceSubcategory.active.label', default: 'Active'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',30,['property':("created"),'title':(message(code: 'serviceSubcategory.created.label', default: 'Created'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',32,['property':("modified"),'title':(message(code: 'serviceSubcategory.modified.label', default: 'Modified'))],-1)
printHtmlPart(15)
loop:{
int i = 0
for( serviceSubcategoryInstance in (serviceSubcategoryInstanceList) ) {
printHtmlPart(16)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(17)
expressionOut.print(fieldValue(bean: serviceSubcategoryInstance, field: "id"))
printHtmlPart(18)
expressionOut.print(fieldValue(bean: serviceSubcategoryInstance, field: "subcategory"))
printHtmlPart(18)
expressionOut.print(fieldValue(bean: serviceSubcategoryInstance, field: "serviceCategory.category"))
printHtmlPart(19)
invokeTag('formatBoolean','g',44,['boolean':(serviceSubcategoryInstance.active)],-1)
printHtmlPart(19)
invokeTag('formatDate','g',46,['date':(serviceSubcategoryInstance.created)],-1)
printHtmlPart(19)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: serviceSubcategoryInstance, field: "modified"))
})
invokeTag('link','g',48,['action':("show"),'id':(serviceSubcategoryInstance.id)],3)
printHtmlPart(18)
createClosureForHtmlPart(20, 3)
invokeTag('link','g',49,['class':("btn-sm btn-info"),'action':("edit"),'id':(serviceSubcategoryInstance.id)],3)
printHtmlPart(21)
createTagBody(3, {->
invokeTag('actionSubmit','g',49,['class':("btn-danger"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
})
invokeTag('form','g',49,['url':([resource:serviceSubcategoryInstance, action:'delete']),'method':("DELETE")],3)
printHtmlPart(22)
i++
}
}
printHtmlPart(23)
invokeTag('paginate','g',55,['total':(serviceSubcategoryInstanceCount ?: 0)],-1)
printHtmlPart(24)
})
invokeTag('captureBody','sitemesh',58,[:],1)
printHtmlPart(25)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1450202644488L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
