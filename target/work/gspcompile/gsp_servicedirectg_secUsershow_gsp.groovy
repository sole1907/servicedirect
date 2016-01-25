import com.soconcepts.servicedirect.SecUser
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_servicedirectg_secUsershow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/secUser/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'secUser.label', default: 'SecUser'))],-1)
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
if(true && (secUserInstance?.username)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("secUser.username.label"),'default':("Username")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',30,['bean':(secUserInstance),'field':("username")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (secUserInstance?.password)) {
printHtmlPart(18)
invokeTag('message','g',37,['code':("secUser.password.label"),'default':("Password")],-1)
printHtmlPart(19)
invokeTag('fieldValue','g',39,['bean':(secUserInstance),'field':("password")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (secUserInstance?.lastname)) {
printHtmlPart(20)
invokeTag('message','g',46,['code':("secUser.lastname.label"),'default':("Lastname")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',48,['bean':(secUserInstance),'field':("lastname")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (secUserInstance?.firstname)) {
printHtmlPart(22)
invokeTag('message','g',55,['code':("secUser.firstname.label"),'default':("Firstname")],-1)
printHtmlPart(23)
invokeTag('fieldValue','g',57,['bean':(secUserInstance),'field':("firstname")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (secUserInstance?.address)) {
printHtmlPart(24)
invokeTag('message','g',64,['code':("secUser.address.label"),'default':("Address")],-1)
printHtmlPart(25)
invokeTag('fieldValue','g',66,['bean':(secUserInstance),'field':("address")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (secUserInstance?.sex)) {
printHtmlPart(26)
invokeTag('message','g',73,['code':("secUser.sex.label"),'default':("Sex")],-1)
printHtmlPart(27)
invokeTag('fieldValue','g',75,['bean':(secUserInstance),'field':("sex")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (secUserInstance?.modified)) {
printHtmlPart(28)
invokeTag('message','g',82,['code':("secUser.modified.label"),'default':("Modified")],-1)
printHtmlPart(29)
invokeTag('formatDate','g',84,['date':(secUserInstance?.modified)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (secUserInstance?.accountExpired)) {
printHtmlPart(30)
invokeTag('message','g',91,['code':("secUser.accountExpired.label"),'default':("Account Expired")],-1)
printHtmlPart(31)
invokeTag('formatBoolean','g',93,['boolean':(secUserInstance?.accountExpired)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (secUserInstance?.accountLocked)) {
printHtmlPart(32)
invokeTag('message','g',100,['code':("secUser.accountLocked.label"),'default':("Account Locked")],-1)
printHtmlPart(33)
invokeTag('formatBoolean','g',102,['boolean':(secUserInstance?.accountLocked)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (secUserInstance?.activationcode)) {
printHtmlPart(34)
invokeTag('message','g',109,['code':("secUser.activationcode.label"),'default':("Activationcode")],-1)
printHtmlPart(35)
invokeTag('fieldValue','g',111,['bean':(secUserInstance),'field':("activationcode")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (secUserInstance?.active)) {
printHtmlPart(36)
invokeTag('message','g',118,['code':("secUser.active.label"),'default':("Active")],-1)
printHtmlPart(37)
invokeTag('formatBoolean','g',120,['boolean':(secUserInstance?.active)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (secUserInstance?.created)) {
printHtmlPart(38)
invokeTag('message','g',127,['code':("secUser.created.label"),'default':("Created")],-1)
printHtmlPart(39)
invokeTag('formatDate','g',129,['date':(secUserInstance?.created)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (secUserInstance?.enabled)) {
printHtmlPart(40)
invokeTag('message','g',136,['code':("secUser.enabled.label"),'default':("Enabled")],-1)
printHtmlPart(41)
invokeTag('formatBoolean','g',138,['boolean':(secUserInstance?.enabled)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (secUserInstance?.lga)) {
printHtmlPart(42)
invokeTag('message','g',145,['code':("secUser.lga.label"),'default':("Lga")],-1)
printHtmlPart(43)
createTagBody(3, {->
expressionOut.print(secUserInstance?.lga?.encodeAsHTML())
})
invokeTag('link','g',147,['controller':("lga"),'action':("show"),'id':(secUserInstance?.lga?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (secUserInstance?.mobile)) {
printHtmlPart(44)
invokeTag('message','g',154,['code':("secUser.mobile.label"),'default':("Mobile")],-1)
printHtmlPart(45)
invokeTag('fieldValue','g',156,['bean':(secUserInstance),'field':("mobile")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (secUserInstance?.passwordExpired)) {
printHtmlPart(46)
invokeTag('message','g',163,['code':("secUser.passwordExpired.label"),'default':("Password Expired")],-1)
printHtmlPart(47)
invokeTag('formatBoolean','g',165,['boolean':(secUserInstance?.passwordExpired)],-1)
printHtmlPart(16)
}
printHtmlPart(48)
createTagBody(2, {->
printHtmlPart(49)
createTagBody(3, {->
invokeTag('message','g',173,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',173,['class':("edit"),'action':("edit"),'resource':(secUserInstance)],3)
printHtmlPart(50)
invokeTag('actionSubmit','g',174,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(51)
})
invokeTag('form','g',176,['url':([resource:secUserInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(52)
})
invokeTag('captureBody','sitemesh',178,[:],1)
printHtmlPart(53)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1444934509133L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
