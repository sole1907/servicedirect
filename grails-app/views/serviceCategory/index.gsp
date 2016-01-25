
<%@ page import="com.soconcepts.servicedirect.ServiceCategory" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'serviceCategory.label', default: 'ServiceCategory')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-serviceCategory" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-serviceCategory" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="modified" title="${message(code: 'serviceCategory.modified.label', default: 'Modified')}" />
					
						<g:sortableColumn property="active" title="${message(code: 'serviceCategory.active.label', default: 'Active')}" />
					
						<g:sortableColumn property="category" title="${message(code: 'serviceCategory.category.label', default: 'Category')}" />
					
						<g:sortableColumn property="created" title="${message(code: 'serviceCategory.created.label', default: 'Created')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${serviceCategoryInstanceList}" status="i" var="serviceCategoryInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${serviceCategoryInstance.id}">${fieldValue(bean: serviceCategoryInstance, field: "modified")}</g:link></td>
					
						<td><g:formatBoolean boolean="${serviceCategoryInstance.active}" /></td>
					
						<td>${fieldValue(bean: serviceCategoryInstance, field: "category")}</td>
					
						<td><g:formatDate date="${serviceCategoryInstance.created}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${serviceCategoryInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
