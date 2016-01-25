
<%@ page import="com.soconcepts.servicedirect.Lga" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'lga.label', default: 'Lga')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-lga" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-lga" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list lga">
			
				<g:if test="${lgaInstance?.lga}">
				<li class="fieldcontain">
					<span id="lga-label" class="property-label"><g:message code="lga.lga.label" default="Lga" /></span>
					
						<span class="property-value" aria-labelledby="lga-label"><g:fieldValue bean="${lgaInstance}" field="lga"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${lgaInstance?.modified}">
				<li class="fieldcontain">
					<span id="modified-label" class="property-label"><g:message code="lga.modified.label" default="Modified" /></span>
					
						<span class="property-value" aria-labelledby="modified-label"><g:formatDate date="${lgaInstance?.modified}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${lgaInstance?.active}">
				<li class="fieldcontain">
					<span id="active-label" class="property-label"><g:message code="lga.active.label" default="Active" /></span>
					
						<span class="property-value" aria-labelledby="active-label"><g:formatBoolean boolean="${lgaInstance?.active}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${lgaInstance?.created}">
				<li class="fieldcontain">
					<span id="created-label" class="property-label"><g:message code="lga.created.label" default="Created" /></span>
					
						<span class="property-value" aria-labelledby="created-label"><g:formatDate date="${lgaInstance?.created}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${lgaInstance?.secUsers}">
				<li class="fieldcontain">
					<span id="secUsers-label" class="property-label"><g:message code="lga.secUsers.label" default="Sec Users" /></span>
					
						<g:each in="${lgaInstance.secUsers}" var="s">
						<span class="property-value" aria-labelledby="secUsers-label"><g:link controller="secUser" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${lgaInstance?.state}">
				<li class="fieldcontain">
					<span id="state-label" class="property-label"><g:message code="lga.state.label" default="State" /></span>
					
						<span class="property-value" aria-labelledby="state-label"><g:link controller="state" action="show" id="${lgaInstance?.state?.id}">${lgaInstance?.state?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:lgaInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${lgaInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
