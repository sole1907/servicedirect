import com.soconcepts.servicedirect.State
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_servicedirectg_stateshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/state/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'state.label', default: 'State'))],-1)
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
if(true && (stateInstance?.state)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("state.state.label"),'default':("State")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',30,['bean':(stateInstance),'field':("state")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (stateInstance?.modified)) {
printHtmlPart(18)
invokeTag('message','g',37,['code':("state.modified.label"),'default':("Modified")],-1)
printHtmlPart(19)
invokeTag('formatDate','g',39,['date':(stateInstance?.modified)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (stateInstance?.active)) {
printHtmlPart(20)
invokeTag('message','g',46,['code':("state.active.label"),'default':("Active")],-1)
printHtmlPart(21)
invokeTag('formatBoolean','g',48,['boolean':(stateInstance?.active)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (stateInstance?.country)) {
printHtmlPart(22)
invokeTag('message','g',55,['code':("state.country.label"),'default':("Country")],-1)
printHtmlPart(23)
createTagBody(3, {->
expressionOut.print(stateInstance?.country?.encodeAsHTML())
})
invokeTag('link','g',57,['controller':("country"),'action':("show"),'id':(stateInstance?.country?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (stateInstance?.created)) {
printHtmlPart(24)
invokeTag('message','g',64,['code':("state.created.label"),'default':("Created")],-1)
printHtmlPart(25)
invokeTag('formatDate','g',66,['date':(stateInstance?.created)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (stateInstance?.lgas)) {
printHtmlPart(26)
invokeTag('message','g',73,['code':("state.lgas.label"),'default':("Lgas")],-1)
printHtmlPart(27)
for( l in (stateInstance.lgas) ) {
printHtmlPart(28)
createTagBody(4, {->
expressionOut.print(l?.encodeAsHTML())
})
invokeTag('link','g',76,['controller':("lga"),'action':("show"),'id':(l.id)],4)
printHtmlPart(29)
}
printHtmlPart(30)
}
printHtmlPart(31)
createTagBody(2, {->
printHtmlPart(32)
createTagBody(3, {->
invokeTag('message','g',85,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',85,['class':("edit"),'action':("edit"),'resource':(stateInstance)],3)
printHtmlPart(33)
invokeTag('actionSubmit','g',86,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(34)
})
invokeTag('form','g',88,['url':([resource:stateInstance, action:'delete']),'method':("DELETE")],2)
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
public static final long LAST_MODIFIED = 1445001578044L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
