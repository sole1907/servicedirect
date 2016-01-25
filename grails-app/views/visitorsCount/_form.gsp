<%@ page import="com.soconcepts.servicedirect.VisitorsCount" %>



<div class="fieldcontain ${hasErrors(bean: visitorsCountInstance, field: 'count', 'error')} required">
	<label for="count">
		<g:message code="visitorsCount.count.label" default="Count" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="count" type="number" value="${visitorsCountInstance.count}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: visitorsCountInstance, field: 'date', 'error')} required">
	<label for="date">
		<g:message code="visitorsCount.date.label" default="Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="date" precision="day"  value="${visitorsCountInstance?.date}"  />

</div>

