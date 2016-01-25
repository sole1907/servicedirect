<%@ page import="com.soconcepts.servicedirect.ProfileViews" %>



<div class="fieldcontain ${hasErrors(bean: profileViewsInstance, field: 'user', 'error')} ">
	<label for="user">
		<g:message code="profileViews.user.label" default="User" />
		
	</label>
	<g:select id="user" name="user.id" from="${com.soconcepts.servicedirect.SecUser.list()}" optionKey="id" value="${profileViewsInstance?.user?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: profileViewsInstance, field: 'created', 'error')} required">
	<label for="created">
		<g:message code="profileViews.created.label" default="Created" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="created" precision="day"  value="${profileViewsInstance?.created}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: profileViewsInstance, field: 'serviceProvider', 'error')} required">
	<label for="serviceProvider">
		<g:message code="profileViews.serviceProvider.label" default="Service Provider" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="serviceProvider" name="serviceProvider.id" from="${com.soconcepts.servicedirect.ServiceProvider.list()}" optionKey="id" required="" value="${profileViewsInstance?.serviceProvider?.id}" class="many-to-one"/>

</div>

