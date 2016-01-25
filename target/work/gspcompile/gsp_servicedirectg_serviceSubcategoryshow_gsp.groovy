import com.soconcepts.servicedirect.ServiceSubcategory
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_servicedirectg_serviceSubcategoryshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/serviceSubcategory/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'serviceSubcategory.label', default: 'ServiceSubcategory'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.show.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',11,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(5)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(6)
invokeTag('message','g',14,['code':("default.home.label")],-1)
printHtmlPart(7)
createTagBody(2, {->
invokeTag('message','g',15,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',15,['class':("list"),'action':("index")],2)
printHtmlPart(8)
createTagBody(2, {->
invokeTag('message','g',16,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',16,['class':("create"),'action':("create")],2)
printHtmlPart(9)
invokeTag('message','g',20,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (serviceSubcategoryInstance?.modified)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("serviceSubcategory.modified.label"),'default':("Modified")],-1)
printHtmlPart(15)
invokeTag('formatDate','g',30,['date':(serviceSubcategoryInstance?.modified)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (serviceSubcategoryInstance?.active)) {
printHtmlPart(18)
invokeTag('message','g',37,['code':("serviceSubcategory.active.label"),'default':("Active")],-1)
printHtmlPart(19)
invokeTag('formatBoolean','g',39,['boolean':(serviceSubcategoryInstance?.active)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (serviceSubcategoryInstance?.created)) {
printHtmlPart(20)
invokeTag('message','g',46,['code':("serviceSubcategory.created.label"),'default':("Created")],-1)
printHtmlPart(21)
invokeTag('formatDate','g',48,['date':(serviceSubcategoryInstance?.created)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (serviceSubcategoryInstance?.serviceCategory)) {
printHtmlPart(22)
invokeTag('message','g',55,['code':("serviceSubcategory.serviceCategory.label"),'default':("Service Category")],-1)
printHtmlPart(23)
createTagBody(3, {->
expressionOut.print(serviceSubcategoryInstance?.serviceCategory?.encodeAsHTML())
})
invokeTag('link','g',57,['controller':("serviceCategory"),'action':("show"),'id':(serviceSubcategoryInstance?.serviceCategory?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (serviceSubcategoryInstance?.serviceProviders)) {
printHtmlPart(24)
invokeTag('message','g',64,['code':("serviceSubcategory.serviceProviders.label"),'default':("Service Providers")],-1)
printHtmlPart(25)
for( s in (serviceSubcategoryInstance.serviceProviders) ) {
printHtmlPart(26)
createTagBody(4, {->
expressionOut.print(s?.encodeAsHTML())
})
invokeTag('link','g',67,['controller':("serviceProvider"),'action':("show"),'id':(s.id)],4)
printHtmlPart(27)
}
printHtmlPart(28)
}
printHtmlPart(17)
if(true && (serviceSubcategoryInstance?.subcategory)) {
printHtmlPart(29)
invokeTag('message','g',75,['code':("serviceSubcategory.subcategory.label"),'default':("Subcategory")],-1)
printHtmlPart(30)
invokeTag('fieldValue','g',77,['bean':(serviceSubcategoryInstance),'field':("subcategory")],-1)
printHtmlPart(16)
}
printHtmlPart(31)
createTagBody(2, {->
printHtmlPart(32)
createTagBody(3, {->
invokeTag('message','g',85,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',85,['class':("edit"),'action':("edit"),'resource':(serviceSubcategoryInstance)],3)
printHtmlPart(33)
invokeTag('actionSubmit','g',86,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(34)
})
invokeTag('form','g',88,['url':([resource:serviceSubcategoryInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(35)
})
invokeTag('captureBody','sitemesh',90,[:],1)
printHtmlPart(36)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1446056997542L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
