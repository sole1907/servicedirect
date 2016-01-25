import com.soconcepts.servicedirect.utils.SessionCounterListener
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_servicedirectg_layoutsmain_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/main.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge,chrome=1")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',11,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',12,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1.0")],-1)
printHtmlPart(3)
expressionOut.print(resource(dir: 'images', file: 'apple-touch-icon.png'))
printHtmlPart(4)
expressionOut.print(resource(dir: 'images', file: 'apple-touch-icon-retina.png'))
printHtmlPart(5)
expressionOut.print(resource(dir: 'css', file: 'home.css'))
printHtmlPart(6)
invokeTag('javascript','g',16,['src':("jquery-1.11.1.min.js")],-1)
printHtmlPart(7)
invokeTag('layoutHead','g',17,[:],-1)
printHtmlPart(8)
invokeTag('layoutResources','r',18,[:],-1)
printHtmlPart(9)
})
invokeTag('captureHead','sitemesh',19,[:],1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
invokeTag('img','g',29,['uri':("/images/nav-icon.png"),'alt':("nav-icon"),'width':("30"),'height':("24")],-1)
printHtmlPart(11)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(12)
invokeTag('img','g',32,['class':("default"),'uri':("/images/servicedirect-logo.png"),'alt':("Logo")],-1)
printHtmlPart(13)
invokeTag('img','g',35,['uri':("/images/ico_phone_26x26.png"),'alt':("ico_phone_26x26"),'width':("26"),'height':("26")],-1)
printHtmlPart(14)
invokeTag('img','g',36,['uri':("/images/ico_phone_26x26.png"),'alt':("ico_phone_26x26"),'width':("26"),'height':("26")],-1)
printHtmlPart(15)
createTagBody(2, {->
printHtmlPart(16)
expressionOut.print(SessionCounterListener.getTotalActiveSession())
printHtmlPart(17)
createTagBody(3, {->
printHtmlPart(18)
invokeTag('loggedInUserInfo','sec',45,['field':("fullName")],-1)
printHtmlPart(19)
createClosureForHtmlPart(20, 4)
invokeTag('link','g',46,['controller':("logout"),'class':("btn-silver btn-rounded-3px btnSignin")],4)
printHtmlPart(21)
})
invokeTag('ifLoggedIn','sec',47,[:],3)
printHtmlPart(22)
})
invokeTag('form','h',49,[:],2)
printHtmlPart(23)
expressionOut.print(createLink(controller: 'v', action: 'howitworks'))
printHtmlPart(24)
expressionOut.print(createLink(controller: 'serviceProvider', action: 'create'))
printHtmlPart(25)
expressionOut.print(createLink(controller: 'secUser', action: 'create'))
printHtmlPart(26)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(27)
expressionOut.print(createLink(controller: 'v', action: 'deals'))
printHtmlPart(28)
createTagBody(2, {->
printHtmlPart(29)
createTagBody(3, {->
printHtmlPart(30)
expressionOut.print(createLink(controller: 'login', action: 'auth'))
printHtmlPart(31)
})
invokeTag('panelGroup','h',67,['rendered':("#{empty sessionScope['firstname']}")],3)
printHtmlPart(32)
})
invokeTag('ifNotLoggedIn','sec',68,[:],2)
printHtmlPart(32)
createTagBody(2, {->
printHtmlPart(29)
createTagBody(3, {->
printHtmlPart(33)
expressionOut.print(createLink(controller: 'secUser', action: 'edit', id: sec.loggedInUserInfo(field:"id")))
printHtmlPart(34)
})
invokeTag('ifAllGranted','sec',72,['roles':("ROLE_ADMIN")],3)
printHtmlPart(29)
createTagBody(3, {->
printHtmlPart(33)
expressionOut.print(createLink(controller: 'secUser', action: 'editProfile'))
printHtmlPart(35)
})
invokeTag('ifAllGranted','sec',75,['roles':("ROLE_USER")],3)
printHtmlPart(29)
createTagBody(3, {->
printHtmlPart(33)
expressionOut.print(createLink(controller: 'serviceProvider', action: 'editProfile'))
printHtmlPart(35)
})
invokeTag('ifAllGranted','sec',78,['roles':("ROLE_SERVICE_PROVIDER")],3)
printHtmlPart(32)
})
invokeTag('ifLoggedIn','sec',79,[:],2)
printHtmlPart(36)
invokeTag('img','g',101,['uri':("/images/nav-icon.png"),'alt':("nav-icon"),'width':("30"),'height':("24")],-1)
printHtmlPart(37)
invokeTag('img','g',104,['class':("default"),'uri':("/images/servicedirect-logo.png"),'alt':("servicedirect")],-1)
printHtmlPart(38)
invokeTag('img','g',107,['uri':("/images/ico_phone_26x26.png"),'alt':("ico_phone_26x26"),'width':("26"),'height':("26")],-1)
printHtmlPart(39)
expressionOut.print(createLink(controller: 'v', action: 'howitworks'))
printHtmlPart(40)
createClosureForHtmlPart(41, 2)
invokeTag('panelGroup','h',123,['rendered':("#{empty sessionScope['firstname']}")],2)
printHtmlPart(42)
expressionOut.print(createLink(controller: 'v', action: 'contactUs'))
printHtmlPart(43)
createTagBody(2, {->
printHtmlPart(44)
createTagBody(3, {->
printHtmlPart(45)
invokeTag('loggedInUserInfo','sec',162,['field':("fullName")],-1)
printHtmlPart(46)
createClosureForHtmlPart(20, 4)
invokeTag('link','g',164,['controller':("logout"),'class':("btn-silver btn-rounded-3px btnSignin")],4)
printHtmlPart(47)
})
invokeTag('ifLoggedIn','sec',166,[:],3)
printHtmlPart(48)
})
invokeTag('form','h',168,[:],2)
printHtmlPart(49)
invokeTag('layoutBody','g',176,[:],-1)
printHtmlPart(50)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(51)
expressionOut.print(createLink(controller: 'v', action: 'howitworks'))
printHtmlPart(52)
expressionOut.print(createLink(controller: 'v', action: 'contactUs'))
printHtmlPart(53)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(54)
expressionOut.print(createLink(controller: 'v', action: 'howitworks'))
printHtmlPart(55)
expressionOut.print(createLink(controller: 'v', action: 'contactUs'))
printHtmlPart(56)
})
invokeTag('captureBody','sitemesh',365,['class':("html not-front not-logged-in no-sidebars page-node page-node- page-node-67216 node-type-page section-aboutushtm")],1)
printHtmlPart(57)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1449309389675L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
