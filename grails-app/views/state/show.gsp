
<%@ page import="com.soconcepts.servicedirect.State" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'state.label', default: 'State')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-state" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-state" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list state">
			
				<g:if test="${stateInstance?.state}">
				<li class="fieldcontain">
					<span id="state-label" class="property-label"><g:message code="state.state.label" default="State" /></span>
					
						<span class="property-value" aria-labelledby="state-label"><g:fieldValue bean="${stateInstance}" field="state"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${stateInstance?.modified}">
				<li class="fieldcontain">
					<span id="modified-label" class="property-label"><g:message code="state.modified.label" default="Modified" /></span>
					
						<span class="property-value" aria-labelledby="modified-label"><g:formatDate date="${stateInstance?.modified}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${stateInstance?.active}">
				<li class="fieldcontain">
					<span id="active-label" class="property-label"><g:message code="state.active.label" default="Active" /></span>
					
						<span class="property-value" aria-labelledby="active-label"><g:formatBoolean boolean="${stateInstance?.active}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${stateInstance?.country}">
				<li class="fieldcontain">
					<span id="country-label" class="property-label"><g:message code="state.country.label" default="Country" /></span>
					
						<span class="property-value" aria-labelledby="country-label"><g:link controller="country" action="show" id="${stateInstance?.country?.id}">${stateInstance?.country?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${stateInstance?.created}">
				<li class="fieldcontain">
					<span id="created-label" class="property-label"><g:message code="state.created.label" default="Created" /></span>
					
						<span class="property-value" aria-labelledby="created-label"><g:formatDate date="${stateInstance?.created}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${stateInstance?.lgas}">
				<li class="fieldcontain">
					<span id="lgas-label" class="property-label"><g:message code="state.lgas.label" default="Lgas" /></span>
					
						<g:each in="${stateInstance.lgas}" var="l">
						<span class="property-value" aria-labelledby="lgas-label"><g:link controller="lga" action="show" id="${l.id}">${l?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:stateInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${stateInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
