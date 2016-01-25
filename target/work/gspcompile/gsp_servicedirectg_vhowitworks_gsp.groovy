import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_servicedirectg_vhowitworks_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/v/howitworks.gsp" }
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
expressionOut.print(resource(dir: 'css', file: 'responsiveslides.css'))
printHtmlPart(4)
expressionOut.print(resource(dir: 'css', file: 'menuhack.css'))
printHtmlPart(5)
invokeTag('javascript','g',14,['src':("responsiveslides.min.js")],-1)
printHtmlPart(6)
})
invokeTag('captureHead','sitemesh',15,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
expressionOut.print(createLink(controller: 'secUser', action: 'create'))
printHtmlPart(8)
invokeTag('img','g',68,['uri':("/images/banner2.jpg"),'class':("heroImage")],-1)
printHtmlPart(9)
invokeTag('img','g',69,['uri':("/images/banner3.jpg")],-1)
printHtmlPart(9)
invokeTag('img','g',70,['uri':("/images/banner4.jpg")],-1)
printHtmlPart(9)
invokeTag('img','g',71,['uri':("/images/banner5.jpg")],-1)
printHtmlPart(9)
invokeTag('img','g',72,['uri':("/images/banner6.jpg")],-1)
printHtmlPart(9)
invokeTag('img','g',73,['uri':("/images/banner7.jpg")],-1)
printHtmlPart(10)
expressionOut.print(createLink(controller: 'secUser', action: 'create'))
printHtmlPart(11)
invokeTag('img','g',92,['uri':("/images/hiw1.jpg"),'alt':("fixxing")],-1)
printHtmlPart(12)
invokeTag('img','g',99,['uri':("/images/hiw2.jpg"),'alt':("ServiceDirect had tons of detailed, local reviews.")],-1)
printHtmlPart(13)
invokeTag('img','g',105,['uri':("/images/hiw3.jpg"),'alt':("Find a winner, and use them.")],-1)
printHtmlPart(14)
invokeTag('img','g',111,['uri':("/images/hiw4.jpg"),'alt':("Post a review of your experience")],-1)
printHtmlPart(15)
expressionOut.print(createLink(controller: 'secUser', action: 'create'))
printHtmlPart(16)
})
invokeTag('captureBody','sitemesh',180,[:],1)
printHtmlPart(17)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1446380826103L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
