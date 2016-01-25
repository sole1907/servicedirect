<%@ page import="com.soconcepts.servicedirect.SecUser" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main_accordion">
        <link rel="stylesheet" href="${resource(dir: 'css', file: 'register.css')}" type="text/css">
        <link rel="stylesheet" href="${resource(dir: 'css', file: 'tooltipster.css')}" type="text/css">
        <g:javascript src="jquery.validate.min.js" />
        <g:javascript src="tooltipster.js" />
        <g:javascript src="registeruser.js" />
    </head>
    <body>
        <div class="nav" role="navigation">
            <div id="edit-secUser" class="content scaffold-edit" role="main">
                <h1>My Profile</h1>
                <g:if test="${flash.message}">
                    <div class="successmsg">
                        <div role="status">${flash.message}</div>
                    </div>
                </g:if>
                <g:hasErrors bean="${secUserInstance}">
                    <div class="errormsg">
                        <ul class="errors" role="alert">
                            <g:eachError bean="${secUserInstance}" var="error">
                                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                                </g:eachError>
                        </ul>
                    </div>
                </g:hasErrors>
                <g:form url="[resource:secUserInstance, action:'update']" method="PUT" id="registeruserForm">
                    <g:hiddenField name="version" value="${secUserInstance?.version}" />
                    <div class="fields">
                        <g:render template="form"/>
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
