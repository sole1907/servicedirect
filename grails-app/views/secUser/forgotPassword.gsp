<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <meta name="layout" content="main"/>
        <link rel="stylesheet" href="${resource(dir: 'css', file: 'register.css')}" type="text/css">
        <link rel="stylesheet" href="${resource(dir: 'css', file: 'tooltipster.css')}" type="text/css">
    </head>
    <body>
        <div id="content" class="column login"><div id="result"></div>
            <g:if test="${flash.message}">
                <div class="successmsg">
                    <div role="status">${flash.message}</div>
                </div>
            </g:if>
            <g:if test="${flash.error}">
                <div class="errormsg">
                    <div role="status">${flash.error}</div>
                </div>
            </g:if>
            <g:form url="[resource:secUserInstance, action:'resetPassword']" method="POST" id="forgotpassForm">
                <input type="hidden" name="forgotpassForm" value="forgotpassForm" />

                <h1>Please Fill the form below to reset your password.</h1>
                <div class="fields">
                    <div class="each_label"><label>Email Address</label></div>
                    <div class="each_input"><input id="email" name="email" placeholder="john.doe@domain.com" type="email" required="required" /></div>

                    <div class="each_label">
                        <div class="download">
                            <g:submitButton name="submit" value="Submit" />
                        </div>
                    </div>

                    <p> </p>

                </div><input type="hidden" name="javax.faces.ViewState" id="j_id1:javax.faces.ViewState:0" value="-5774704782908164117:4532435584363863722" autocomplete="off" />
            </g:form>
        </div>
    </body>
</html>
