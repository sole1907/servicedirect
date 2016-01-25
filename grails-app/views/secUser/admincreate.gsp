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
        <div id="main" class="clearfix with-navigation">
            <div id="content" class="column"><div class="section">
                    <div style="clear:both;"></div>
                    <a id="main-content"></a>
                    <div class="region region-content">
                        <div id="block-system-main" class="block block-system first last odd">


                            <div class="content">
                                <div class="inner-panels margin-center">
                                    <div class="panel-panel panel-full-head">
                                        <div class="panel-pane pane-breadcrumb-block clearfix">


                                        </div>
                                        <div class="panel-separator"></div>

                                        <div class="panel-pane pane-node-content">

                                            <div class="pane-content">
                                                <div id="node-67216" class="node node-page view-mode-full clearfix">
                                                    <div class="content">

                                                        <div class="field field-name-body field-type-text-with-summary field-label-hidden clearfix">
                                                            <div class="field-items">
                                                                <div class="field-item even">
                                                                    <div id="aboutUsContainer">
                                                                        <!-- You can put your contents Here!  -->

                                                                        <div id="content" class="column login"><div id="result"></div>
                                                                            <div class="loading" style="display:none">Hang on while we process your request ...</div>
                                                                            <div id="create-secUser" class="content scaffold-create" role="main">
                                                                                <h1><g:message code="default.form.instruction" /></h1>
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
                                                                                <g:form url="[resource:secUserInstance, action:'save']" id="registeruserForm">
                                                                                    <div class="fields">
                                                                                        <g:render template="form" model="[create:true]"/>
                                                                                        <div class="each_label">
                                                                                            <div class="download">

                                                                                                <g:submitButton name="create" class="save" value="${message(code: 'default.button.submit.label', default: 'Submit')}" />
                                                                                            </div>
                                                                                        </div>
                                                                                    </div>
                                                                                </g:form>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
