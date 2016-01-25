import com.soconcepts.servicedirect.ServiceProvider
import com.soconcepts.servicedirect.ServiceProviderReview
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_servicedirectg_serviceProvidershow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/serviceProvider/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(3)
expressionOut.print(resource(dir: 'css', file: 'viewdetails.css'))
printHtmlPart(4)
invokeTag('javascript','g',9,['src':("ratings.js")],-1)
printHtmlPart(2)
invokeTag('javascript','g',10,['src':("serviceprovider.js")],-1)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',12,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
if(true && (serviceProviderInstance.picture)) {
printHtmlPart(9)
invokeTag('img','g',25,['uri':("/images/uploads/${serviceProviderInstance.picture}"),'width':("150"),'height':("150")],-1)
printHtmlPart(10)
}
else {
printHtmlPart(9)
invokeTag('img','g',28,['uri':("/images/provider-logo.jpg"),'width':("150"),'height':("150")],-1)
printHtmlPart(10)
}
printHtmlPart(11)
expressionOut.print(serviceProviderInstance.user.firstname)
printHtmlPart(12)
expressionOut.print(serviceProviderInstance.user.lastname)
printHtmlPart(13)
if(true && (reviews)) {
printHtmlPart(14)
expressionOut.print(totalrating/reviews.size())
printHtmlPart(15)
}
else {
printHtmlPart(16)
}
printHtmlPart(17)
expressionOut.print(serviceProviderInstance.about)
printHtmlPart(18)
for( review in (reviews) ) {
printHtmlPart(19)
if(true && (review.ratedBy)) {
printHtmlPart(20)
expressionOut.print(review.ratedBy.firstname)
printHtmlPart(21)
}
else {
printHtmlPart(20)
expressionOut.print(review.raterName)
printHtmlPart(21)
}
printHtmlPart(9)
expressionOut.print(review.comment)
printHtmlPart(22)
}
printHtmlPart(23)
if(true && (flash.message)) {
printHtmlPart(24)
expressionOut.print(flash.message)
printHtmlPart(25)
}
printHtmlPart(26)
if(true && (flash.error)) {
printHtmlPart(27)
expressionOut.print(flash.error)
printHtmlPart(25)
}
printHtmlPart(26)
createTagBody(3, {->
printHtmlPart(28)
createTagBody(4, {->
printHtmlPart(29)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(30)
expressionOut.print(error.field)
printHtmlPart(31)
}
printHtmlPart(32)
invokeTag('message','g',80,['error':(error)],-1)
printHtmlPart(33)
})
invokeTag('eachError','g',81,['bean':(serviceProviderReviewInstance),'var':("error")],4)
printHtmlPart(34)
})
invokeTag('hasErrors','g',84,['bean':(serviceProviderReviewInstance)],3)
printHtmlPart(35)
createClosureForHtmlPart(36, 3)
invokeTag('ifNotLoggedIn','sec',90,[:],3)
printHtmlPart(10)
createTagBody(3, {->
printHtmlPart(37)
invokeTag('loggedInUserInfo','sec',92,['field':("fullName")],-1)
printHtmlPart(38)
})
invokeTag('ifLoggedIn','sec',93,[:],3)
printHtmlPart(39)
invokeTag('submitButton','g',107,['name':("comment"),'class':("save btn search"),'value':("Make Comment")],-1)
printHtmlPart(40)
})
invokeTag('form','g',114,['url':([resource:serviceProviderInstance, action:'serviceProviderRating']),'method':("POST"),'id':("rateSpForm")],2)
printHtmlPart(41)
})
invokeTag('captureBody','sitemesh',137,[:],1)
printHtmlPart(42)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1448212380768L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
