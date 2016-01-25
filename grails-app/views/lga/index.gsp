
<%@ page import="com.soconcepts.servicedirect.Lga" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main_accordion">
    </head>
    <body>
        <div class="nav" role="navigation">
            <ul>
                <g:link class="create btn btn-primary" action="create">New LGA</g:link>
                </ul>
            </div>
            <div id="list-lga" class="content scaffold-list" role="main">
                <h1>List LGAs</h1>
            <g:if test="${flash.message}">
                <div class="infomsg" role="status">${flash.message}</div>
            </g:if>
            <b>Total Count: ${lgaInstanceCount}</b>
            <table class="table table-responsive table-striped">
                <thead>
                    <tr>
                        <g:sortableColumn property="id" title="${message(code: 'lga.id.label', default: 'ID')}" />

                        <g:sortableColumn property="lga" title="${message(code: 'lga.lga.label', default: 'Lga')}" />
                        <th><g:message code="lga.state.label" default="State" /></th>

                            <g:sortableColumn property="active" title="${message(code: 'lga.active.label', default: 'Active')}" />

                            <g:sortableColumn property="created" title="${message(code: 'lga.created.label', default: 'Created')}" />
                            <g:sortableColumn property="modified" title="${message(code: 'lga.modified.label', default: 'Modified')}" />
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <g:each in="${lgaInstanceList}" status="i" var="lgaInstance">
                        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                            <td>${fieldValue(bean: lgaInstance, field: "id")}</td>
                            <td>${fieldValue(bean: lgaInstance, field: "lga")}</td>
                            <td>${fieldValue(bean: lgaInstance, field: "state.state")}</td>

                            <td><g:formatBoolean boolean="${lgaInstance.active}" /></td>

                            <td><g:formatDate date="${lgaInstance.created}" /></td>
                            <td><g:formatDate date="${lgaInstance.modified}" /></td>
                            <td><g:link class="btn-sm btn-info" action="edit" id="${lgaInstance.id}">Edit</g:link> <g:form url="[resource:lgaInstance, action:'delete']" method="DELETE"><g:actionSubmit class="btn-danger" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></g:form></td>
                            </tr>
                    </g:each>
                </tbody>
            </table>
            <div class="pagination">
                <g:paginate total="${lgaInstanceCount ?: 0}" />
            </div>
        </div>
    </body>
</html>
