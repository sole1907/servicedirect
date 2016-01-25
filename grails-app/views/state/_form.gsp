<%@ page import="com.soconcepts.servicedirect.State" %>

<div class="fieldcontain ${hasErrors(bean: stateInstance, field: 'country', 'error')} required">
    <label for="country">
        <g:message code="state.country.label" default="Country" />
        <span class="required-indicator">*</span>
    </label>
    <g:select id="country" name="country.id" from="${com.soconcepts.servicedirect.Country.list()}" optionKey="id" optionValue="country" required="" value="${stateInstance?.country?.id}" class="many-to-one form-control"/>

</div>

<div class="fieldcontain ${hasErrors(bean: stateInstance, field: 'state', 'error')} required">
    <label for="state">
        <g:message code="state.state.label" default="State" />
        <span class="required-indicator">*</span>
    </label>
    <g:textField class="form-control" name="state" maxlength="45" required="" value="${stateInstance?.state}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: stateInstance, field: 'active', 'error')} ">
    <label for="active">
        <g:message code="state.active.label" default="Active" />

    </label>
    <g:checkBox name="active" value="${stateInstance?.active}" />

</div>


