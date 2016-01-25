package com.soconcepts.servicedirect



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Transactional(readOnly = true)
@Secured(['ROLE_ADMIN'])
class ServiceSubcategoryController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ServiceSubcategory.list(params), model:[serviceSubcategoryInstanceCount: ServiceSubcategory.count()]
    }

    def show(ServiceSubcategory serviceSubcategoryInstance) {
        respond serviceSubcategoryInstance
    }

    def create() {
        respond new ServiceSubcategory(params)
    }

    @Transactional
    def save(ServiceSubcategory serviceSubcategoryInstance) {
        if (serviceSubcategoryInstance == null) {
            notFound()
            return
        }

        if (serviceSubcategoryInstance.hasErrors()) {
            respond serviceSubcategoryInstance.errors, view:'create'
            return
        }

        serviceSubcategoryInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = "Sub Category Successfully Added"
                redirect(action: 'index')
            }
            '*' { respond serviceSubcategoryInstance, [status: CREATED] }
        }
    }

    def edit(ServiceSubcategory serviceSubcategoryInstance) {
        respond serviceSubcategoryInstance
    }

    @Transactional
    def update(ServiceSubcategory serviceSubcategoryInstance) {
        if (serviceSubcategoryInstance == null) {
            notFound()
            return
        }

        if (serviceSubcategoryInstance.hasErrors()) {
            respond serviceSubcategoryInstance.errors, view:'edit'
            return
        }

        serviceSubcategoryInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = "Sub Category Successfully Updated"
                redirect(action: 'index')
            }
            '*'{ respond serviceSubcategoryInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(ServiceSubcategory serviceSubcategoryInstance) {

        if (serviceSubcategoryInstance == null) {
            notFound()
            return
        }

        serviceSubcategoryInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = "Sub Category Successfully Deleted"
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'serviceSubcategory.label', default: 'ServiceSubcategory'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
