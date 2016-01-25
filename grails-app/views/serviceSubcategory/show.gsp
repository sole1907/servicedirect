
<%@ page import="com.soconcepts.servicedirect.ServiceSubcategory" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'serviceSubcategory.label', default: 'ServiceSubcategory')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-serviceSubcategory" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-serviceSubcategory" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list serviceSubcategory">
			
				<g:if test="${serviceSubcategoryInstance?.modified}">
				<li class="fieldcontain">
					<span id="modified-label" class="property-label"><g:message code="serviceSubcategory.modified.label" default="Modified" /></span>
					
						<span class="property-value" aria-labelledby="modified-label"><g:formatDate date="${serviceSubcategoryInstance?.modified}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${serviceSubcategoryInstance?.active}">
				<li class="fieldcontain">
					<span id="active-label" class="property-label"><g:message code="serviceSubcategory.active.label" default="Active" /></span>
					
						<span class="property-value" aria-labelledby="active-label"><g:formatBoolean boolean="${serviceSubcategoryInstance?.active}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${serviceSubcategoryInstance?.created}">
				<li class="fieldcontain">
					<span id="created-label" class="property-label"><g:message code="serviceSubcategory.created.label" default="Created" /></span>
					
						<span class="property-value" aria-labelledby="created-label"><g:formatDate date="${serviceSubcategoryInstance?.created}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${serviceSubcategoryInstance?.serviceCategory}">
				<li class="fieldcontain">
					<span id="serviceCategory-label" class="property-label"><g:message code="serviceSubcategory.serviceCategory.label" default="Service Category" /></span>
					
						<span class="property-value" aria-labelledby="serviceCategory-label"><g:link controller="serviceCategory" action="show" id="${serviceSubcategoryInstance?.serviceCategory?.id}">${serviceSubcategoryInstance?.serviceCategory?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${serviceSubcategoryInstance?.serviceProviders}">
				<li class="fieldcontain">
					<span id="serviceProviders-label" class="property-label"><g:message code="serviceSubcategory.serviceProviders.label" default="Service Providers" /></span>
					
						<g:each in="${serviceSubcategoryInstance.serviceProviders}" var="s">
						<span class="property-value" aria-labelledby="serviceProviders-label"><g:link controller="serviceProvider" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${serviceSubcategoryInstance?.subcategory}">
				<li class="fieldcontain">
					<span id="subcategory-label" class="property-label"><g:message code="serviceSubcategory.subcategory.label" default="Subcategory" /></span>
					
						<span class="property-value" aria-labelledby="subcategory-label"><g:fieldValue bean="${serviceSubcategoryInstance}" field="subcategory"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:serviceSubcategoryInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${serviceSubcategoryInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
