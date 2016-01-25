import com.soconcepts.servicedirect.ProfileViews
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_servicedirectg_profileViewsprofileviews_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/profileViews/profileviews.gsp" }
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
if(true && (flash.message)) {
printHtmlPart(5)
expressionOut.print(flash.message)
printHtmlPart(6)
}
printHtmlPart(7)
invokeTag('message','g',18,['code':("profileViews.user.label"),'default':("Viewed By")],-1)
printHtmlPart(8)
invokeTag('sortableColumn','g',19,['property':("created"),'title':(message(code: 'profileViews.created.label', default: 'Viewed On'))],-1)
printHtmlPart(9)
loop:{
int i = 0
for( profileViewsInstance in (profileViewsInstanceList) ) {
printHtmlPart(10)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(11)
expressionOut.print(profileViewsInstance.user ? profileViewsInstance.user.username : "Anonymous")
printHtmlPart(12)
invokeTag('formatDate','g',26,['date':(profileViewsInstance.created)],-1)
printHtmlPart(13)
i++
}
}
printHtmlPart(14)
invokeTag('paginate','g',33,['total':(profileViewsInstanceCount ?: 0)],-1)
printHtmlPart(15)
})
invokeTag('captureBody','sitemesh',36,[:],1)
printHtmlPart(16)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1450025646899L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
