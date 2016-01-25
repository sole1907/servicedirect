import com.soconcepts.servicedirect.State
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_servicedirectg_state_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/state/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: stateInstance, field: 'country', 'error'))
printHtmlPart(1)
invokeTag('message','g',5,['code':("state.country.label"),'default':("Country")],-1)
printHtmlPart(2)
invokeTag('select','g',8,['id':("country"),'name':("country.id"),'from':(com.soconcepts.servicedirect.Country.list()),'optionKey':("id"),'optionValue':("country"),'required':(""),'value':(stateInstance?.country?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: stateInstance, field: 'state', 'error'))
printHtmlPart(4)
invokeTag('message','g',14,['code':("state.state.label"),'default':("State")],-1)
printHtmlPart(2)
invokeTag('textField','g',17,['class':("form-control"),'name':("state"),'maxlength':("45"),'required':(""),'value':(stateInstance?.state)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: stateInstance, field: 'active', 'error'))
printHtmlPart(5)
invokeTag('message','g',23,['code':("state.active.label"),'default':("Active")],-1)
printHtmlPart(6)
invokeTag('checkBox','g',26,['name':("active"),'value':(stateInstance?.active)],-1)
printHtmlPart(7)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1446225516102L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
