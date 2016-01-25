<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main_accordion">
    </head>
    <body>
        <div id="create-state" class="content scaffold-create" role="main">
            <h1>Add New State</h1>
            <g:if test="${flash.message}">
                <div class="infomsg" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${stateInstance}">
                <ul class="errors" role="alert">
                    <g:eachError bean="${stateInstance}" var="error">
                        <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                        </g:eachError>
                </ul>
            </g:hasErrors>
            <g:form url="[resource:stateInstance, action:'save']" >
                <g:render template="form"/>
                <div class="each_label">
                    <div class="download">
                        <g:submitButton name="create" class="save btn btn-primary" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                        <g:link class="list btn btn-warning" action="index">Cancel</g:link>
                        </div>
                    </div>
            </g:form>
        </div>
    </body>
</html>
