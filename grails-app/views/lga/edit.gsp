<%@ page import="com.soconcepts.servicedirect.Lga" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main_accordion">
    </head>
    <body>
        <div id="edit-lga" class="content scaffold-edit" role="main">
            <h1>Edit LGA</h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${lgaInstance}">
                <ul class="errors" role="alert">
                    <g:eachError bean="${lgaInstance}" var="error">
                        <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                        </g:eachError>
                </ul>
            </g:hasErrors>
            <g:form url="[resource:lgaInstance, action:'update']" method="PUT" >
                <g:hiddenField name="version" value="${lgaInstance?.version}" />
                <g:render template="form"/>
                <div class="each_label">
                    <div class="download">
                        <g:submitButton name="update" action="update" class="save btn btn-primary" value="${message(code: 'default.button.update.label', default: 'Update')}" />
                        <g:link class="list btn btn-warning" action="index">Cancel</g:link>
                        </div>
                    </div>
            </g:form>
        </div>
    </body>
</html>
