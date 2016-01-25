
<%@ page import="com.soconcepts.servicedirect.VisitorsCount" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main_accordion">
    </head>
    <body>
        <div id="list-visitorsCount" class="content scaffold-list" role="main">
            <h1>Site Visits</h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <table class="table table-responsive table-striped">
                <thead>
                    <tr>

                        <g:sortableColumn property="date" title="${message(code: 'visitorsCount.date.label', default: 'Date')}" />
                        <g:sortableColumn property="count" title="${message(code: 'visitorsCount.count.label', default: 'Count')}" />
                    </tr>
                </thead>
                <tbody>
                    <g:each in="${visitorsCountInstanceList}" status="i" var="visitorsCountInstance">
                        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                            <td><g:formatDate date="${visitorsCountInstance.date}" /></td>
                            <td><g:link action="show" id="${visitorsCountInstance.id}">${fieldValue(bean: visitorsCountInstance, field: "count")}</g:link></td>


                        </tr>
                    </g:each>
                </tbody>
            </table>
            <div class="pagination">
                <g:paginate total="${visitorsCountInstanceCount ?: 0}" />
            </div>
        </div>
    </body>
</html>
