
<%@ page import="com.soconcepts.servicedirect.ProfileViews" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main_accordion">
    </head>
    <body>
        <div id="list-profileViews" class="content scaffold-list" role="main">
            <h1>Profile Views</h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <div class="table-responsive">
                <table class="table table-responsive table-striped" style="overflow-x: scroll;">
                    <thead>
                        <tr>
                            <th><g:message code="profileViews.serviceProvider.label" default="Profile Viewed" /></th>
                                <g:sortableColumn property="created" title="${message(code: 'profileViews.created.label', default: 'Viewed On')}" />
                        </tr>
                    </thead>
                    <tbody style="overflow-x: scroll;">
                        <g:each in="${profileViewsInstanceList}" status="i" var="profileViewsInstance">
                            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                <td><a href="${createLink(controller: 'serviceProvider', action: 'show', id: profileViewsInstance.serviceProvider.id)}">${fieldValue(bean: profileViewsInstance, field: "serviceProvider.companyName")}</a></td>
                                <td><g:formatDate date="${profileViewsInstance.created}" /></td>
                            </tr>
                        </g:each>
                    </tbody>
                </table>
            </div>
            <div class="pagination">
                <g:paginate total="${profileViewsInstanceCount ?: 0}" />
            </div>
        </div>
    </body>
</html>
