
<%@ page import="com.soconcepts.servicedirect.SecUser" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'secUser.label', default: 'SecUser')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-secUser" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-secUser" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list secUser">
			
				<g:if test="${secUserInstance?.username}">
				<li class="fieldcontain">
					<span id="username-label" class="property-label"><g:message code="secUser.username.label" default="Username" /></span>
					
						<span class="property-value" aria-labelledby="username-label"><g:fieldValue bean="${secUserInstance}" field="username"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${secUserInstance?.password}">
				<li class="fieldcontain">
					<span id="password-label" class="property-label"><g:message code="secUser.password.label" default="Password" /></span>
					
						<span class="property-value" aria-labelledby="password-label"><g:fieldValue bean="${secUserInstance}" field="password"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${secUserInstance?.lastname}">
				<li class="fieldcontain">
					<span id="lastname-label" class="property-label"><g:message code="secUser.lastname.label" default="Lastname" /></span>
					
						<span class="property-value" aria-labelledby="lastname-label"><g:fieldValue bean="${secUserInstance}" field="lastname"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${secUserInstance?.firstname}">
				<li class="fieldcontain">
					<span id="firstname-label" class="property-label"><g:message code="secUser.firstname.label" default="Firstname" /></span>
					
						<span class="property-value" aria-labelledby="firstname-label"><g:fieldValue bean="${secUserInstance}" field="firstname"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${secUserInstance?.address}">
				<li class="fieldcontain">
					<span id="address-label" class="property-label"><g:message code="secUser.address.label" default="Address" /></span>
					
						<span class="property-value" aria-labelledby="address-label"><g:fieldValue bean="${secUserInstance}" field="address"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${secUserInstance?.sex}">
				<li class="fieldcontain">
					<span id="sex-label" class="property-label"><g:message code="secUser.sex.label" default="Sex" /></span>
					
						<span class="property-value" aria-labelledby="sex-label"><g:fieldValue bean="${secUserInstance}" field="sex"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${secUserInstance?.modified}">
				<li class="fieldcontain">
					<span id="modified-label" class="property-label"><g:message code="secUser.modified.label" default="Modified" /></span>
					
						<span class="property-value" aria-labelledby="modified-label"><g:formatDate date="${secUserInstance?.modified}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${secUserInstance?.accountExpired}">
				<li class="fieldcontain">
					<span id="accountExpired-label" class="property-label"><g:message code="secUser.accountExpired.label" default="Account Expired" /></span>
					
						<span class="property-value" aria-labelledby="accountExpired-label"><g:formatBoolean boolean="${secUserInstance?.accountExpired}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${secUserInstance?.accountLocked}">
				<li class="fieldcontain">
					<span id="accountLocked-label" class="property-label"><g:message code="secUser.accountLocked.label" default="Account Locked" /></span>
					
						<span class="property-value" aria-labelledby="accountLocked-label"><g:formatBoolean boolean="${secUserInstance?.accountLocked}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${secUserInstance?.activationcode}">
				<li class="fieldcontain">
					<span id="activationcode-label" class="property-label"><g:message code="secUser.activationcode.label" default="Activationcode" /></span>
					
						<span class="property-value" aria-labelledby="activationcode-label"><g:fieldValue bean="${secUserInstance}" field="activationcode"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${secUserInstance?.active}">
				<li class="fieldcontain">
					<span id="active-label" class="property-label"><g:message code="secUser.active.label" default="Active" /></span>
					
						<span class="property-value" aria-labelledby="active-label"><g:formatBoolean boolean="${secUserInstance?.active}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${secUserInstance?.created}">
				<li class="fieldcontain">
					<span id="created-label" class="property-label"><g:message code="secUser.created.label" default="Created" /></span>
					
						<span class="property-value" aria-labelledby="created-label"><g:formatDate date="${secUserInstance?.created}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${secUserInstance?.enabled}">
				<li class="fieldcontain">
					<span id="enabled-label" class="property-label"><g:message code="secUser.enabled.label" default="Enabled" /></span>
					
						<span class="property-value" aria-labelledby="enabled-label"><g:formatBoolean boolean="${secUserInstance?.enabled}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${secUserInstance?.lga}">
				<li class="fieldcontain">
					<span id="lga-label" class="property-label"><g:message code="secUser.lga.label" default="Lga" /></span>
					
						<span class="property-value" aria-labelledby="lga-label"><g:link controller="lga" action="show" id="${secUserInstance?.lga?.id}">${secUserInstance?.lga?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${secUserInstance?.mobile}">
				<li class="fieldcontain">
					<span id="mobile-label" class="property-label"><g:message code="secUser.mobile.label" default="Mobile" /></span>
					
						<span class="property-value" aria-labelledby="mobile-label"><g:fieldValue bean="${secUserInstance}" field="mobile"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${secUserInstance?.passwordExpired}">
				<li class="fieldcontain">
					<span id="passwordExpired-label" class="property-label"><g:message code="secUser.passwordExpired.label" default="Password Expired" /></span>
					
						<span class="property-value" aria-labelledby="passwordExpired-label"><g:formatBoolean boolean="${secUserInstance?.passwordExpired}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:secUserInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${secUserInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
