import com.soconcepts.servicedirect.ProfileViews
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_servicedirectg_profileViews_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/profileViews/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: profileViewsInstance, field: 'user', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("profileViews.user.label"),'default':("User")],-1)
printHtmlPart(2)
invokeTag('select','g',10,['id':("user"),'name':("user.id"),'from':(com.soconcepts.servicedirect.SecUser.list()),'optionKey':("id"),'value':(profileViewsInstance?.user?.id),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: profileViewsInstance, field: 'created', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("profileViews.created.label"),'default':("Created")],-1)
printHtmlPart(5)
invokeTag('datePicker','g',19,['name':("created"),'precision':("day"),'value':(profileViewsInstance?.created)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: profileViewsInstance, field: 'serviceProvider', 'error'))
printHtmlPart(6)
invokeTag('message','g',25,['code':("profileViews.serviceProvider.label"),'default':("Service Provider")],-1)
printHtmlPart(5)
invokeTag('select','g',28,['id':("serviceProvider"),'name':("serviceProvider.id"),'from':(com.soconcepts.servicedirect.ServiceProvider.list()),'optionKey':("id"),'required':(""),'value':(profileViewsInstance?.serviceProvider?.id),'class':("many-to-one")],-1)
printHtmlPart(7)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1450023874287L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
