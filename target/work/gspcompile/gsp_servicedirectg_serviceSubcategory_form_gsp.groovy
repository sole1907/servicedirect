import com.soconcepts.servicedirect.ServiceSubcategory
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_servicedirectg_serviceSubcategory_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/serviceSubcategory/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: serviceSubcategoryInstance, field: 'serviceCategory', 'error'))
printHtmlPart(1)
invokeTag('message','g',5,['code':("serviceSubcategory.serviceCategory.label"),'default':("Service Category")],-1)
printHtmlPart(2)
invokeTag('select','g',8,['id':("serviceCategory"),'name':("serviceCategory.id"),'from':(com.soconcepts.servicedirect.ServiceCategory.list()),'optionKey':("id"),'optionValue':("category"),'required':(""),'value':(serviceSubcategoryInstance?.serviceCategory?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: serviceSubcategoryInstance, field: 'subcategory', 'error'))
printHtmlPart(4)
invokeTag('message','g',14,['code':("serviceSubcategory.subcategory.label"),'default':("Subcategory")],-1)
printHtmlPart(2)
invokeTag('textField','g',17,['name':("subcategory"),'class':("form-control"),'required':(""),'value':(serviceSubcategoryInstance?.subcategory)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: serviceSubcategoryInstance, field: 'active', 'error'))
printHtmlPart(5)
invokeTag('message','g',23,['code':("serviceSubcategory.active.label"),'default':("Active")],-1)
printHtmlPart(6)
invokeTag('checkBox','g',26,['name':("active"),'value':(serviceSubcategoryInstance?.active)],-1)
printHtmlPart(7)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1446135524616L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
