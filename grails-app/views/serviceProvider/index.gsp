
<%@ page import="com.soconcepts.servicedirect.ServiceProvider" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main_accordion">
    </head>
    <body>
        <div class="nav" role="navigation">
            <ul>
                <g:link class="create btn btn-primary" action="admincreate">New Service Provder</g:link>
            </div>
            <div id="list-serviceProvider" class="content scaffold-list" role="main">
                <h1>Service Providers List</h1>
            <g:if test="${flash.message}">
                <div class="infomsg" role="status">${flash.message}</div>
            </g:if>
            <b>Total Count: ${serviceProviderInstanceCount}</b>
            <div class="table-responsive">
            <table class="table table-responsive table-striped" style="overflow-x: scroll;">
                <thead>
                    <tr>
                        <g:sortableColumn property="companyName" title="${message(code: 'serviceProvider.companyName.label', default: 'Company Name')}" />
                        <g:sortableColumn property="about" title="${message(code: 'serviceProvider.about.label', default: 'About')}" />
                        <th><g:message code="serviceProvider.user.address.label" default="Address" /></th>
                        <th><g:message code="serviceProvider.user.lga.label" default="LGA" /></th>
                        <th><g:message code="serviceProvider.user.state.label" default="State" /></th>
                        <th><g:message code="serviceProvider.user.email.label" default="Email" /></th>
                        <th><g:message code="serviceProvider.user.mobile.label" default="Mobile" /></th>
                        <th><g:message code="serviceProvider.user.name.label" default="Name" /></th>
                        <th><g:message code="serviceProvider.user.active.label" default="Active" /></th>
                        <th><g:message code="serviceProvider.user.created.label" default="Created" /></th>
                        <th><g:message code="serviceProvider.modified.label" default="Modified" /></th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody style="overflow-x: scroll;">
                    <g:each in="${serviceProviderInstanceList}" status="i" var="serviceProviderInstance">
                        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                            <td>${fieldValue(bean: serviceProviderInstance, field: "companyName")}</td>
                            <td>${fieldValue(bean: serviceProviderInstance, field: "about")}</td>
                            <td>${fieldValue(bean: serviceProviderInstance, field: "user.address")}</td>
                            <td>${fieldValue(bean: serviceProviderInstance, field: "user.lga.lga")}</td>
                            <td>${fieldValue(bean: serviceProviderInstance, field: "user.lga.state.state")}</td>
                            <td>${fieldValue(bean: serviceProviderInstance, field: "user.username")}</td>
                            <td>${fieldValue(bean: serviceProviderInstance, field: "user.mobile")}</td>
                            <td>${fieldValue(bean: serviceProviderInstance, field: "user.firstname")} ${fieldValue(bean: serviceProviderInstance, field: "user.lastname")}</td>
                            <td>${fieldValue(bean: serviceProviderInstance, field: "user.active")}</td>
                            <td>${fieldValue(bean: serviceProviderInstance, field: "user.created")}</td>
                            <td>${fieldValue(bean: serviceProviderInstance, field: "modified")}</td>
                            <td><g:link class="btn-sm btn-info" action="edit" id="${serviceProviderInstance.id}">Edit</g:link> <g:form url="[resource:serviceProviderInstance, action:'delete']" method="DELETE"><g:actionSubmit class="btn-danger" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></g:form></td>
                            </tr>
                    </g:each>
                </tbody>
            </table>
            </div>
            <div class="pagination">
                <g:paginate total="${serviceProviderInstanceCount ?: 0}" />
            </div>
        </div>
    </body>
</html>
