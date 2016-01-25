<%@ page import="com.soconcepts.servicedirect.ServiceProvider" %>

<div class="fieldcontain ${hasErrors(bean: secUserInstance, field: 'firstname', 'error')} required">
    <label for="firstname" class="each_label">
        <g:message code="secUser.firstname.label" default="First Name" />
        <span class="required-indicator">*</span>
    </label>
    <g:textField class="each_input" name="user.firstname" maxlength="45" required="" value="${serviceProviderInstance?.user?.firstname}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: secUserInstance, field: 'lastname', 'error')} required">
    <label for="lastname" class="each_label">
        <g:message code="secUser.lastname.label" default="Last Name" />
        <span class="required-indicator">*</span>
    </label>
    <g:textField class="each_input" name="user.lastname" maxlength="45" required="" value="${serviceProviderInstance?.user?.lastname}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: serviceProviderInstance, field: 'companyName', 'error')} required">
    <label for="companyName" class="each_label">
        <g:message code="serviceProvider.companyName.label" default="Company Name" />
        <span class="required-indicator">*</span>
    </label>
    <g:textField class="each_input" name="companyName" required="" value="${serviceProviderInstance?.companyName}"/>
</div>

<div class="fieldcontain required">
    <label for="state" class="each_label">
        <g:message code="state.label" default="State of Residence" />
        <span class="required-indicator">*</span>
    </label>
    <g:select id="state" class="each_input" name="state.id" noSelection="${['':'Select State of Residence ...']}" from="${com.soconcepts.servicedirect.State.list()}" optionKey="id" required="" optionValue="state" class="many-to-one" value="${serviceProviderInstance?.user?.lga?.state?.id}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: secUserInstance, field: 'lga', 'error')} required">
    <label for="lga" class="each_label">
        <g:message code="secUser.lga.label" default="LGA" />
        <span class="required-indicator">*</span>
    </label>
    <g:select id="lga" class="each_input" noSelection="${['':'Select LGA ...']}" name="user.lga.id" from="${com.soconcepts.servicedirect.Lga.stateLgasByStateId(serviceProviderInstance?.user?.lga?.state?.id)}" optionKey="id" optionValue="lga" required="" value="${serviceProviderInstance?.user?.lga?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: secUserInstance, field: 'address', 'error')} required">
    <label for="address" class="each_label">
        <g:message code="serviceProvider.address.label" default="Business Address" />
        <span class="required-indicator">*</span>
    </label>
    <g:textArea class="each_input" name="user.address" cols="40" rows="5" maxlength="255" required="" value="${serviceProviderInstance?.user?.address}"/>

</div>

<div class="fieldcontain required">
    <label for="category" class="each_label">
        <g:message code="category.label" default="Select Company Category" />
        <span class="required-indicator">*</span>
    </label>
    <g:select id="category" class="each_input" name="category.id" noSelection="${['':'Select your Company Category ...']}" from="${com.soconcepts.servicedirect.ServiceCategory.list()}" optionKey="id" required="" optionValue="category" class="many-to-one" value="${serviceProviderInstance?.serviceSubcategories?.first()?.serviceCategory?.id}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: serviceProviderInstance, field: 'serviceSubcategories', 'error')} ">
    <label for="serviceSubcategories" class="each_label">
        <g:message code="serviceProvider.serviceSubcategories.label" default="Select the Service(s) you Provide (Ctrl + Click to select multiple options)" />

    </label>
    <g:select id="subcategory" style="height: auto;" noSelection="${['':'Select Services you Provide ...']}" name="serviceSubcategories" from="${com.soconcepts.servicedirect.ServiceSubcategory.categorySubsByCatId(serviceProviderInstance?.serviceSubcategories?.first()?.serviceCategory?.id)}" multiple="multiple" optionKey="id" size="7" value="${serviceProviderInstance?.serviceSubcategories*.id}" optionValue="subcategory" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: serviceProviderInstance, field: 'about', 'error')}">
    <label for="about" class="each_label">
        <g:message code="serviceProvider.about.label" default="About your Company (Max of 200 characters)" />
    </label>
    <g:textArea class="each_input" name="about" required="" value="${serviceProviderInstance?.about}" maxlength="200"/>
</div>

<div class="fieldcontain ${hasErrors(bean: secUserInstance, field: 'mobile', 'error')} required">
    <label for="mobile" class="each_label">
        <g:message code="secUser.mobile.label" default="Phone Number" />
        <span class="required-indicator">*</span>
    </label>
    <g:textField class="each_input" name="user.mobile" required="" value="${serviceProviderInstance?.user?.mobile}"/>

</div>

<div class="fieldcontain">
    <label for="logo" class="each_label">
        <g:message code="serviceProvider.logo.label" default="Logo (Size: 150px x 150px)" />
    </label>
    <input class="each_input" type="file" name="logo"/>
</div>

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

    $("#category").change(function() {
    if (this.value != "") {
    $.ajax({
    url: "/servicedirectg/serviceCategory/categorySelected",
    data: "id=" + this.value,
    cache: false,
    success: function(html) {
    $("#subcategory").html(html);
    }
    });
    }
    });
    });
</script>
