import com.soconcepts.servicedirect.VisitorsCount
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_servicedirectg_visitorsCountindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/visitorsCount/index.gsp" }
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
invokeTag('sortableColumn','g',18,['property':("date"),'title':(message(code: 'visitorsCount.date.label', default: 'Date'))],-1)
printHtmlPart(8)
invokeTag('sortableColumn','g',19,['property':("count"),'title':(message(code: 'visitorsCount.count.label', default: 'Count'))],-1)
printHtmlPart(9)
loop:{
int i = 0
for( visitorsCountInstance in (visitorsCountInstanceList) ) {
printHtmlPart(10)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(11)
invokeTag('formatDate','g',25,['date':(visitorsCountInstance.date)],-1)
printHtmlPart(12)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: visitorsCountInstance, field: "count"))
})
invokeTag('link','g',26,['action':("show"),'id':(visitorsCountInstance.id)],3)
printHtmlPart(13)
i++
}
}
printHtmlPart(14)
invokeTag('paginate','g',34,['total':(visitorsCountInstanceCount ?: 0)],-1)
printHtmlPart(15)
})
invokeTag('captureBody','sitemesh',37,[:],1)
printHtmlPart(16)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1446750059585L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
