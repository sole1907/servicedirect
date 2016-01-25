import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_servicedirectgindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
expressionOut.print(resource(dir: 'css', file: 'search.css'))
printHtmlPart(3)
expressionOut.print(resource(dir: 'css', file: 'tooltipster.css'))
printHtmlPart(3)
expressionOut.print(resource(dir: 'css', file: 'jquery-ui.min.css'))
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
if(true && (flash.noresult)) {
printHtmlPart(10)
expressionOut.print(flash.noresult)
printHtmlPart(11)
}
printHtmlPart(12)
createTagBody(2, {->
printHtmlPart(13)
invokeTag('select','g',72,['id':("state"),'name':("state.id"),'noSelection':(['':'Select State ...']),'from':(com.soconcepts.servicedirect.State.list()),'optionKey':("id"),'required':(""),'optionValue':("state")],-1)
printHtmlPart(14)
invokeTag('select','g',75,['id':("lga"),'noSelection':(['':'Select LGA ...']),'name':("lga"),'from':([]),'optionKey':("id"),'optionValue':("lga"),'required':(""),'value':(secUserInstance?.lga?.id)],-1)
printHtmlPart(15)
invokeTag('select','g',78,['id':("category"),'name':("category.id"),'noSelection':(['':'Select Category ...']),'from':(com.soconcepts.servicedirect.ServiceCategory.list()),'optionKey':("id"),'required':(""),'optionValue':("category")],-1)
printHtmlPart(16)
invokeTag('select','g',82,['id':("subcategory"),'noSelection':(['':'Select Service ...']),'name':("serviceSubcategory"),'from':([]),'optionKey':("id"),'value':(serviceProviderInstance?.serviceSubcategories*.id)],-1)
printHtmlPart(17)
})
invokeTag('form','g',84,['url':([action:'findServiceProviders',controller:'v']),'method':("post"),'id':("findProvidersForm")],2)
printHtmlPart(18)
invokeTag('img','g',93,['uri':("/images/maps.jpg")],-1)
printHtmlPart(19)
})
invokeTag('captureBody','sitemesh',166,[:],1)
printHtmlPart(20)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1445623083967L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
