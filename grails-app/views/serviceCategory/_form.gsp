<%@ page import="com.soconcepts.servicedirect.ServiceCategory" %>



<div class="fieldcontain ${hasErrors(bean: serviceCategoryInstance, field: 'modified', 'error')} ">
	<label for="modified">
		<g:message code="serviceCategory.modified.label" default="Modified" />
		
	</label>
	<g:datePicker name="modified" precision="day"  value="${serviceCategoryInstance?.modified}" default="none" noSelection="['': '']" />

</div>

<div class="fieldcontain ${hasErrors(bean: serviceCategoryInstance, field: 'active', 'error')} ">
	<label for="active">
		<g:message code="serviceCategory.active.label" default="Active" />
		
	</label>
	<g:checkBox name="active" value="${serviceCategoryInstance?.active}" />

</div>

<div class="fieldcontain ${hasErrors(bean: serviceCategoryInstance, field: 'category', 'error')} required">
	<label for="category">
		<g:message code="serviceCategory.category.label" default="Category" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="category" required="" value="${serviceCategoryInstance?.category}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: serviceCategoryInstance, field: 'created', 'error')} required">
	<label for="created">
		<g:message code="serviceCategory.created.label" default="Created" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="created" precision="day"  value="${serviceCategoryInstance?.created}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: serviceCategoryInstance, field: 'serviceSubcategories', 'error')} ">
	<label for="serviceSubcategories">
		<g:message code="serviceCategory.serviceSubcategories.label" default="Service Subcategories" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${serviceCategoryInstance?.serviceSubcategories?}" var="s">
    <li><g:link controller="serviceSubcategory" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="serviceSubcategory" action="create" params="['serviceCategory.id': serviceCategoryInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'serviceSubcategory.label', default: 'ServiceSubcategory')])}</g:link>
</li>
</ul>


</div>

