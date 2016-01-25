
<%@ page import="com.soconcepts.servicedirect.SecUser" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main_accordion">
    </head>
    <body>
        <div class="nav" role="navigation">
            <ul>
                <g:link class="create btn btn-primary" action="admincreate">New User</g:link>
                </ul>
            </div>
            <div id="list-secUser" class="content scaffold-list" role="main">
                <h1>Users List</h1>
            <g:if test="${flash.message}">
                <div class="infomsg" role="status">${flash.message}</div>
            </g:if>
            <b>Total Count: ${secUserInstanceCount}</b>
            <div class="table-responsive">
                <table class="table table-responsive table-striped" style="overflow-x: scroll;">
                    <thead>
                        <tr>
                            <th><g:message code="secUser.name.label" default="Name" /></th>
                                <g:sortableColumn property="sex" title="${message(code: 'secUser.sex.label', default: 'Sex')}" />
                                <g:sortableColumn property="address" title="${message(code: 'secUser.address.label', default: 'Address')}" />
                            <th><g:message code="secUser.lga.label" default="LGA" /></th>
                            <th><g:message code="secUser.state.label" default="State" /></th>
                                <g:sortableColumn property="email" title="${message(code: 'secUser.email.label', default: 'Email')}" />
                                <g:sortableColumn property="mobile" title="${message(code: 'secUser.mobile.label', default: 'Mobile')}" />
                                <g:sortableColumn property="active" title="${message(code: 'secUser.active.label', default: 'Active')}" />
                            <th><g:message code="secUser.created.label" default="Created" /></th>
                            <th><g:message code="secUser.modified.label" default="Modified" /></th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <g:each in="${secUserInstanceList}" status="i" var="secUserInstance">
                            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                <td>${fieldValue(bean: secUserInstance, field: "firstname")} ${fieldValue(bean: secUserInstance, field: "lastname")}</td>
                                <td>${fieldValue(bean: secUserInstance, field: "sex")}</td>
                                <td>${fieldValue(bean: secUserInstance, field: "address")}</td>
                                <td>${fieldValue(bean: secUserInstance, field: "lga.lga")}</td>
                                <td>${fieldValue(bean: secUserInstance, field: "lga.state.state")}</td>
                                <td>${fieldValue(bean: secUserInstance, field: "username")}</td>
                                <td>${fieldValue(bean: secUserInstance, field: "mobile")}</td>
                                <td>${fieldValue(bean: secUserInstance, field: "active")}</td>
                                <td>${fieldValue(bean: secUserInstance, field: "created")}</td>
                                <td>${fieldValue(bean: secUserInstance, field: "modified")}</td>
                                <td><g:link class="btn-sm btn-info" action="edit" id="${secUserInstance.id}">Edit</g:link> <g:form url="[resource:secUserInstance, action:'delete']" method="DELETE"><g:actionSubmit class="btn-danger" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></g:form></td>

                            </tr>
                        </g:each>
                    </tbody>
                </table>
            </div>
            <div class="pagination">
                <g:paginate total="${secUserInstanceCount ?: 0}" />
            </div>
        </div>
    </body>
</html>
