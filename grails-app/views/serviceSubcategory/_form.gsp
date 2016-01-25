<%@ page import="com.soconcepts.servicedirect.ServiceSubcategory" %>

<div class="fieldcontain ${hasErrors(bean: serviceSubcategoryInstance, field: 'serviceCategory', 'error')} required">
	<label for="serviceCategory">
		<g:message code="serviceSubcategory.serviceCategory.label" default="Service Category" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="serviceCategory" name="serviceCategory.id" from="${com.soconcepts.servicedirect.ServiceCategory.list()}" optionKey="id" optionValue="category" required="" value="${serviceSubcategoryInstance?.serviceCategory?.id}" class="many-to-one form-control"/>

</div>

<div class="fieldcontain ${hasErrors(bean: serviceSubcategoryInstance, field: 'subcategory', 'error')} required">
	<label for="subcategory">
		<g:message code="serviceSubcategory.subcategory.label" default="Subcategory" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="subcategory" class="form-control" required="" value="${serviceSubcategoryInstance?.subcategory}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: serviceSubcategoryInstance, field: 'active', 'error')} ">
	<label for="active">
		<g:message code="serviceSubcategory.active.label" default="Active" />
		
	</label>
	<g:checkBox name="active" value="${serviceSubcategoryInstance?.active}" />

</div>

