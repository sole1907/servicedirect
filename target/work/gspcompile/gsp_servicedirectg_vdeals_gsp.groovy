import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_servicedirectg_vdeals_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/v/deals.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',11,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(3)
expressionOut.print(resource(dir: 'css', file: 'deals.css'))
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',32,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
invokeTag('img','g',113,['uri':("/images/one.jpg")],-1)
printHtmlPart(7)
invokeTag('img','g',124,['uri':("/images/one.jpg")],-1)
printHtmlPart(8)
invokeTag('img','g',135,['uri':("/images/one.jpg")],-1)
printHtmlPart(9)
invokeTag('img','g',144,['uri':("/images/one.jpg")],-1)
printHtmlPart(10)
invokeTag('img','g',158,['uri':("/images/one.jpg")],-1)
printHtmlPart(11)
invokeTag('img','g',167,['uri':("/images/one.jpg")],-1)
printHtmlPart(9)
invokeTag('img','g',176,['uri':("/images/one.jpg")],-1)
printHtmlPart(9)
invokeTag('img','g',185,['uri':("/images/one.jpg")],-1)
printHtmlPart(12)
})
invokeTag('captureBody','sitemesh',244,[:],1)
printHtmlPart(13)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1446486453551L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
