
<%@ page import="com.soconcepts.servicedirect.ProfileViews" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'profileViews.label', default: 'ProfileViews')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-profileViews" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-profileViews" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list profileViews">
			
				<g:if test="${profileViewsInstance?.user}">
				<li class="fieldcontain">
					<span id="user-label" class="property-label"><g:message code="profileViews.user.label" default="User" /></span>
					
						<span class="property-value" aria-labelledby="user-label"><g:link controller="secUser" action="show" id="${profileViewsInstance?.user?.id}">${profileViewsInstance?.user?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${profileViewsInstance?.created}">
				<li class="fieldcontain">
					<span id="created-label" class="property-label"><g:message code="profileViews.created.label" default="Created" /></span>
					
						<span class="property-value" aria-labelledby="created-label"><g:formatDate date="${profileViewsInstance?.created}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${profileViewsInstance?.serviceProvider}">
				<li class="fieldcontain">
					<span id="serviceProvider-label" class="property-label"><g:message code="profileViews.serviceProvider.label" default="Service Provider" /></span>
					
						<span class="property-value" aria-labelledby="serviceProvider-label"><g:link controller="serviceProvider" action="show" id="${profileViewsInstance?.serviceProvider?.id}">${profileViewsInstance?.serviceProvider?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:profileViewsInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${profileViewsInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
