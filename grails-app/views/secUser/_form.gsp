<%@ page import="com.soconcepts.servicedirect.SecUser" %>

<div class="fieldcontain ${hasErrors(bean: secUserInstance, field: 'firstname', 'error')} required">
    <label for="firstname" class="each_label">
        <g:message code="secUser.firstname.label" default="First Name" />
        <span class="required-indicator">*</span>
    </label>
    <g:textField class="each_input" name="firstname" maxlength="45" required="" value="${secUserInstance?.firstname}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: secUserInstance, field: 'lastname', 'error')} required">
    <label for="lastname" class="each_label">
        <g:message code="secUser.lastname.label" default="Last Name" />
        <span class="required-indicator">*</span>
    </label>
    <g:textField class="each_input" name="lastname" maxlength="45" required="" value="${secUserInstance?.lastname}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: secUserInstance, field: 'sex', 'error')} required">
    <label for="sex" class="each_label">
        <g:message code="secUser.sex.label" default="Gender" />
        <span class="required-indicator">*</span>
    </label>
    <g:select class="each_input" noSelection="${['':'Select your Gender ...']}" name="sex" from="${['Female','Male']}" required="" value="${secUserInstance?.sex}"/>

</div>

<div class="fieldcontain required">
    <label for="state" class="each_label">
        <g:message code="state.label" default="State of Residence" />
        <span class="required-indicator">*</span>
    </label>
    <g:select id="state" class="each_input" name="state.id" noSelection="${['':'Select State of Residence ...']}" from="${com.soconcepts.servicedirect.State.list()}" optionKey="id" required="" optionValue="state" class="many-to-one" value="${secUserInstance?.lga?.state?.id}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: secUserInstance, field: 'lga', 'error')} required">
    <label for="lga" class="each_label">
        <g:message code="secUser.lga.label" default="LGA" />
        <span class="required-indicator">*</span>
    </label>
    <g:select id="lga" class="each_input" noSelection="${['':'Select LGA ...']}" name="lga.id" from="${com.soconcepts.servicedirect.Lga.stateLgasByStateId(secUserInstance?.lga?.state?.id)}" optionKey="id" optionValue="lga" required="" value="${secUserInstance?.lga?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: secUserInstance, field: 'address', 'error')} required">
    <label for="address" class="each_label">
        <g:message code="secUser.address.label" default="Address" />
        <span class="required-indicator">*</span>
    </label>
    <g:textArea class="each_input" name="address" cols="40" rows="5" maxlength="255" required="" value="${secUserInstance?.address}"/>

</div>

<g:if test="${create}">
    <div class="fieldcontain ${hasErrors(bean: secUserInstance, field: 'username', 'error')} required">
        <label for="username" class="each_label">
            <g:message code="secUser.username.label" default="Email Address" />
            <span class="required-indicator">*</span>
        </label>
        <g:field type="email" class="each_input" name="username" required="" value="${secUserInstance?.username}"/>

    </div>
</g:if>
<div class="fieldcontain ${hasErrors(bean: secUserInstance, field: 'mobile', 'error')} required">
    <label for="mobile" class="each_label">
        <g:message code="secUser.mobile.label" default="Phone Number" />
        <span class="required-indicator">*</span>
    </label>
    <g:textField class="each_input" name="mobile" required="" value="${secUserInstance?.mobile}"/>

</div>

<g:if test="${create}">
    <div class="fieldcontain ${hasErrors(bean: secUserInstance, field: 'password', 'error')} required">
        <label for="password" class="each_label">
            <g:message code="secUser.password.label" default="Password" />
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
</g:if>
<script>
    $(document).ready(function() {
    $("#state").change(function() {
    if (this.value != "") {
    $.ajax({
    url: "/servicedirectg/state/stateSelected",
    data: "id=" + this.value,
    cache: false,
    success: function(html) {
    $("#lga").html(html);
    }
    });
    }
    });
    });
</script>
