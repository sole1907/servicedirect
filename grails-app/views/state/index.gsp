
<%@ page import="com.soconcepts.servicedirect.State" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main_accordion">
    </head>
    <body>
        <div class="nav" role="navigation">
            <ul>
                <g:link class="create btn btn-primary" action="create">New State</g:link>
                </ul>
            </div>
            <div id="list-state" class="content scaffold-list" role="main">
                <h1>States List</h1>
            <g:if test="${flash.message}">
                <div class="infomsg" role="status">${flash.message}</div>
            </g:if>
            <b>Total Count: ${stateInstanceCount}</b>
            <table class="table table-responsive table-striped">
                <thead>
                    <tr>
                        <g:sortableColumn property="id" title="${message(code: 'state.id.label', default: 'ID')}" />

                        <g:sortableColumn property="state" title="${message(code: 'state.state.label', default: 'State')}" />

                        <th><g:message code="state.country.label" default="Country" /></th>
                            <g:sortableColumn property="created" title="${message(code: 'state.created.label', default: 'Created')}" />
                            <g:sortableColumn property="modified" title="${message(code: 'state.modified.label', default: 'Modified')}" />

                            <g:sortableColumn property="active" title="${message(code: 'state.active.label', default: 'Active')}" />
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <g:each in="${stateInstanceList}" status="i" var="stateInstance">
                        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                            <td>${fieldValue(bean: stateInstance, field: "id")}</td>

                            <td><g:link action="show" id="${stateInstance.id}">${fieldValue(bean: stateInstance, field: "state")}</g:link></td>

                            <td>${fieldValue(bean: stateInstance, field: "country.country")}</td>

                            <td><g:formatBoolean boolean="${stateInstance.active}" /></td>


                            <td><g:formatDate date="${stateInstance.created}" /></td>
                            <td><g:formatDate date="${stateInstance.modified}" /></td>
                            <td><g:link class="btn-sm btn-info" action="edit" id="${stateInstance.id}">Edit</g:link> <g:form url="[resource:stateInstance, action:'delete']" method="DELETE"><g:actionSubmit class="btn-danger" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></g:form></td>
                            </tr>
                    </g:each>
                </tbody>
            </table>
            <div class="pagination pagination-lg">
                <g:paginate total="${stateInstanceCount ?: 0}" />
            </div>
        </div>
    </body>
</html>
