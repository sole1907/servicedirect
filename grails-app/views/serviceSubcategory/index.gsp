
<%@ page import="com.soconcepts.servicedirect.ServiceSubcategory" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main_accordion">
    </head>
    <body>
        <div class="nav" role="navigation">
            <ul>
                <g:link class="create btn btn-primary" action="create">New Sub Category</g:link>
                </ul>
            </div>
            <div id="list-serviceSubcategory" class="content scaffold-list" role="main">
                <h1>Sub Categories List</h1>
            <g:if test="${flash.message}">
                <div class="infomsg" role="status">${flash.message}</div>
            </g:if>
            <b>Total Count: ${serviceSubcategoryInstanceCount}</b>
            <table class="table table-responsive table-striped">
                <thead>
                    <tr>
                        <g:sortableColumn property="id" title="${message(code: 'serviceSubcategory.id.label', default: 'ID')}" />
                        <g:sortableColumn property="subcategory" title="${message(code: 'serviceSubcategory.subcategory.label', default: 'Subcategory')}" />

                        <th><g:message code="serviceSubcategory.serviceCategory.label" default="Service Category" /></th>

                            <g:sortableColumn property="active" title="${message(code: 'serviceSubcategory.active.label', default: 'Active')}" />

                            <g:sortableColumn property="created" title="${message(code: 'serviceSubcategory.created.label', default: 'Created')}" />

                            <g:sortableColumn property="modified" title="${message(code: 'serviceSubcategory.modified.label', default: 'Modified')}" />

                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <g:each in="${serviceSubcategoryInstanceList}" status="i" var="serviceSubcategoryInstance">
                        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                            <td>${fieldValue(bean: serviceSubcategoryInstance, field: "id")}</td>
                            <td>${fieldValue(bean: serviceSubcategoryInstance, field: "subcategory")}</td>
                            <td>${fieldValue(bean: serviceSubcategoryInstance, field: "serviceCategory.category")}</td>

                            <td><g:formatBoolean boolean="${serviceSubcategoryInstance.active}" /></td>

                            <td><g:formatDate date="${serviceSubcategoryInstance.created}" /></td>

                            <td><g:link action="show" id="${serviceSubcategoryInstance.id}">${fieldValue(bean: serviceSubcategoryInstance, field: "modified")}</g:link></td>
                            <td><g:link class="btn-sm btn-info" action="edit" id="${serviceSubcategoryInstance.id}">Edit</g:link> <g:form url="[resource:serviceSubcategoryInstance, action:'delete']" method="DELETE"><g:actionSubmit class="btn-danger" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></g:form></td>
                            </tr>
                    </g:each>
                </tbody>
            </table>
            <div class="pagination pagination-lg">
                <g:paginate total="${serviceSubcategoryInstanceCount ?: 0}" />
            </div>
        </div>
    </body>
</html>
