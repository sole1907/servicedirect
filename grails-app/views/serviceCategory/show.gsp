
<%@ page import="com.soconcepts.servicedirect.ServiceCategory" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'serviceCategory.label', default: 'ServiceCategory')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-serviceCategory" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-serviceCategory" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list serviceCategory">
			
				<g:if test="${serviceCategoryInstance?.modified}">
				<li class="fieldcontain">
					<span id="modified-label" class="property-label"><g:message code="serviceCategory.modified.label" default="Modified" /></span>
					
						<span class="property-value" aria-labelledby="modified-label"><g:formatDate date="${serviceCategoryInstance?.modified}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${serviceCategoryInstance?.active}">
				<li class="fieldcontain">
					<span id="active-label" class="property-label"><g:message code="serviceCategory.active.label" default="Active" /></span>
					
						<span class="property-value" aria-labelledby="active-label"><g:formatBoolean boolean="${serviceCategoryInstance?.active}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${serviceCategoryInstance?.category}">
				<li class="fieldcontain">
					<span id="category-label" class="property-label"><g:message code="serviceCategory.category.label" default="Category" /></span>
					
						<span class="property-value" aria-labelledby="category-label"><g:fieldValue bean="${serviceCategoryInstance}" field="category"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${serviceCategoryInstance?.created}">
				<li class="fieldcontain">
					<span id="created-label" class="property-label"><g:message code="serviceCategory.created.label" default="Created" /></span>
					
						<span class="property-value" aria-labelledby="created-label"><g:formatDate date="${serviceCategoryInstance?.created}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${serviceCategoryInstance?.serviceSubcategories}">
				<li class="fieldcontain">
					<span id="serviceSubcategories-label" class="property-label"><g:message code="serviceCategory.serviceSubcategories.label" default="Service Subcategories" /></span>
					
						<g:each in="${serviceCategoryInstance.serviceSubcategories}" var="s">
						<span class="property-value" aria-labelledby="serviceSubcategories-label"><g:link controller="serviceSubcategory" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:serviceCategoryInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${serviceCategoryInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
