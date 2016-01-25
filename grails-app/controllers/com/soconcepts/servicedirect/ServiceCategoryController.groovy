package com.soconcepts.servicedirect



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Transactional(readOnly = true)
class ServiceCategoryController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ServiceCategory.list(params), model:[serviceCategoryInstanceCount: ServiceCategory.count()]
    }

    def show(ServiceCategory serviceCategoryInstance) {
        respond serviceCategoryInstance
    }

    def create() {
        respond new ServiceCategory(params)
    }

    @Transactional
    def save(ServiceCategory serviceCategoryInstance) {
        if (serviceCategoryInstance == null) {
            notFound()
            return
        }

        if (serviceCategoryInstance.hasErrors()) {
            respond serviceCategoryInstance.errors, view:'create'
            return
        }

        serviceCategoryInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'serviceCategory.label', default: 'ServiceCategory'), serviceCategoryInstance.id])
                redirect serviceCategoryInstance
            }
            '*' { respond serviceCategoryInstance, [status: CREATED] }
        }
    }

    def edit(ServiceCategory serviceCategoryInstance) {
       respond serviceCategoryInstance
    }

    @Transactional
    def update(ServiceCategory serviceCategoryInstance) {
        if (serviceCategoryInstance == null) {
            notFound()
            return
        }

        if (serviceCategoryInstance.hasErrors()) {
            respond serviceCategoryInstance.errors, view:'edit'
            return
        }

        serviceCategoryInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ServiceCategory.label', default: 'ServiceCategory'), serviceCategoryInstance.id])
                redirect serviceCategoryInstance
            }
            '*'{ respond serviceCategoryInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(ServiceCategory serviceCategoryInstance) {

        if (serviceCategoryInstance == null) {
            notFound()
            return
        }

        serviceCategoryInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ServiceCategory.label', default: 'ServiceCategory'), serviceCategoryInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def categorySelected() {
        def category = ServiceCategory.findById(params.id)
        render g.select(optionKey: 'id', optionValue: 'subcategory', from: category.serviceSubcategories, id: 'subcategory', name: "serviceSubcategories")
    }
    
    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'serviceCategory.label', default: 'ServiceCategory'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
