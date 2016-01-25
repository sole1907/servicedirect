import com.soconcepts.servicedirect.ServiceCategory
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_servicedirectg_serviceCategory_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/serviceCategory/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: serviceCategoryInstance, field: 'modified', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("serviceCategory.modified.label"),'default':("Modified")],-1)
printHtmlPart(2)
invokeTag('datePicker','g',10,['name':("modified"),'precision':("day"),'value':(serviceCategoryInstance?.modified),'default':("none"),'noSelection':(['': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: serviceCategoryInstance, field: 'active', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("serviceCategory.active.label"),'default':("Active")],-1)
printHtmlPart(2)
invokeTag('checkBox','g',19,['name':("active"),'value':(serviceCategoryInstance?.active)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: serviceCategoryInstance, field: 'category', 'error'))
printHtmlPart(5)
invokeTag('message','g',25,['code':("serviceCategory.category.label"),'default':("Category")],-1)
printHtmlPart(6)
invokeTag('textField','g',28,['name':("category"),'required':(""),'value':(serviceCategoryInstance?.category)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: serviceCategoryInstance, field: 'created', 'error'))
printHtmlPart(7)
invokeTag('message','g',34,['code':("serviceCategory.created.label"),'default':("Created")],-1)
printHtmlPart(6)
invokeTag('datePicker','g',37,['name':("created"),'precision':("day"),'value':(serviceCategoryInstance?.created)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: serviceCategoryInstance, field: 'serviceSubcategories', 'error'))
printHtmlPart(8)
invokeTag('message','g',43,['code':("serviceCategory.serviceSubcategories.label"),'default':("Service Subcategories")],-1)
printHtmlPart(9)
for( s in (serviceCategoryInstance?.serviceSubcategories) ) {
printHtmlPart(10)
createTagBody(2, {->
expressionOut.print(s?.encodeAsHTML())
})
invokeTag('link','g',49,['controller':("serviceSubcategory"),'action':("show"),'id':(s.id)],2)
printHtmlPart(11)
}
printHtmlPart(12)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'serviceSubcategory.label', default: 'ServiceSubcategory')]))
})
invokeTag('link','g',52,['controller':("serviceSubcategory"),'action':("create"),'params':(['serviceCategory.id': serviceCategoryInstance?.id])],1)
printHtmlPart(13)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1445178786321L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
