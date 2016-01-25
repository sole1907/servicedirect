<%@ page import="com.soconcepts.servicedirect.ServiceProvider" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main_accordion">
        <link rel="stylesheet" href="${resource(dir: 'css', file: 'register.css')}" type="text/css">
        <link rel="stylesheet" href="${resource(dir: 'css', file: 'tooltipster.css')}" type="text/css">
        <g:javascript src="jquery.validate.min.js" />
        <g:javascript src="tooltipster.js" />
        <g:javascript src="register.js" />
    </head>
    <body>
        <div id="edit-serviceProvider" class="content scaffold-edit" role="main">
            <h1>My Profile</h1>
            <g:if test="${flash.message}">
                <div class="successmsg">
                    <div role="status">${flash.message}</div>
                </div>
            </g:if>
            <g:hasErrors bean="${serviceProviderInstance}">
                <div class="errormsg">
                    <ul class="errors" role="alert">
                        <g:eachError bean="${serviceProviderInstance}" var="error">
                            <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                            </g:eachError>
                    </ul>
                </div>
            </g:hasErrors>
            <g:if test="${serviceProviderInstance.picture}">
                <g:img uri="/images/uploads/${serviceProviderInstance.picture}" width="150" height="150" />
            </g:if>
            <g:else>
                <g:img uri="/images/provider-logo.jpg" width="150" height="150" />
            </g:else>
            <g:form url="[resource:serviceProviderInstance, action:'update']" method="POST" id="registerForm" enctype="multipart/form-data">
                <g:hiddenField name="version" value="${serviceProviderInstance?.version}" />
                <div class="fields">
                    <g:render template="updateform"/>
                    <div class="each_label">
                        <div class="download">
                            <g:submitButton name="create" class="save" value="${message(code: 'default.button.update.label', default: 'Update')}" />
                        </div>
                    </div>
                </div>
            </g:form>
        </div>
    </body>
</html>
