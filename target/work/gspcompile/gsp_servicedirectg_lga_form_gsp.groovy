import com.soconcepts.servicedirect.Lga
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_servicedirectg_lga_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/lga/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: lgaInstance, field: 'state', 'error'))
printHtmlPart(1)
invokeTag('message','g',5,['code':("lga.state.label"),'default':("State")],-1)
printHtmlPart(2)
invokeTag('select','g',8,['id':("state"),'name':("state.id"),'from':(com.soconcepts.servicedirect.State.list()),'optionKey':("id"),'optionValue':("state"),'required':(""),'value':(lgaInstance?.state?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: lgaInstance, field: 'lga', 'error'))
printHtmlPart(4)
invokeTag('message','g',14,['code':("lga.lga.label"),'default':("Lga")],-1)
printHtmlPart(2)
invokeTag('textField','g',17,['name':("lga"),'maxlength':("45"),'required':(""),'value':(lgaInstance?.lga),'class':("form-control")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: lgaInstance, field: 'active', 'error'))
printHtmlPart(5)
invokeTag('message','g',23,['code':("lga.active.label"),'default':("Active")],-1)
printHtmlPart(6)
invokeTag('checkBox','g',26,['name':("active"),'value':(lgaInstance?.active)],-1)
printHtmlPart(7)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1446321176394L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
