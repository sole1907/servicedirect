<%@ page import="com.soconcepts.servicedirect.SecUser" %>

<div class="fieldcontain ${hasErrors(bean: secUserInstance, field: 'password', 'error')} required">
    <label for="password" class="each_label">
        <g:message code="secUser.newpassword.label" default="New Password" />
        <span class="required-indicator">*</span>
    </label>
    <g:passwordField class="each_input" name="password" required="" value="${secUserInstance?.password}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: secUserInstance, field: 'password', 'error')} required">
    <label for="confirmpassword" class="each_label">
        <g:message code="secUser.password.label" default="Confirm Password" />
        <span class="required-indicator">*</span>
    </label>
    <g:passwordField class="each_input" name="password_again" required=""/>

</div>