<%@ page import="com.soconcepts.servicedirect.Lga" %>

<div class="fieldcontain ${hasErrors(bean: lgaInstance, field: 'state', 'error')} required">
    <label for="state">
        <g:message code="lga.state.label" default="State" />
        <span class="required-indicator">*</span>
    </label>
    <g:select id="state" name="state.id" from="${com.soconcepts.servicedirect.State.list()}" optionKey="id" optionValue="state" required="" value="${lgaInstance?.state?.id}" class="many-to-one form-control"/>

</div>

<div class="fieldcontain ${hasErrors(bean: lgaInstance, field: 'lga', 'error')} required">
    <label for="lga">
        <g:message code="lga.lga.label" default="Lga" />
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="lga" maxlength="45" required="" value="${lgaInstance?.lga}" class="form-control" />

</div>

<div class="fieldcontain ${hasErrors(bean: lgaInstance, field: 'active', 'error')} ">
    <label for="active">
        <g:message code="lga.active.label" default="Active" />

    </label>
    <g:checkBox name="active" value="${lgaInstance?.active}" />

</div>
