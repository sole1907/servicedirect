package com.soconcepts.servicedirect



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Transactional(readOnly = true)
@Secured(['ROLE_ADMIN'])
class LgaController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Lga.list(params), model:[lgaInstanceCount: Lga.count()]
    }

    def show(Lga lgaInstance) {
        respond lgaInstance
    }

    def create() {
        respond new Lga(params)
    }

    @Transactional
    def save(Lga lgaInstance) {
        if (lgaInstance == null) {
            notFound()
            return
        }

        if (lgaInstance.hasErrors()) {
            respond lgaInstance.errors, view:'create'
            return
        }

        lgaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = "LGA Successfully Added"
                redirect(action: 'index')
            }
            '*' { respond lgaInstance, [status: CREATED] }
        }
    }

    def edit(Lga lgaInstance) {
        respond lgaInstance
    }

    @Transactional
    def update(Lga lgaInstance) {
        if (lgaInstance == null) {
            notFound()
            return
        }

        if (lgaInstance.hasErrors()) {
            respond lgaInstance.errors, view:'edit'
            return
        }

        lgaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = "LGA Successfully Updated"
                redirect(action: 'index')
            }
            '*'{ respond lgaInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Lga lgaInstance) {

        if (lgaInstance == null) {
            notFound()
            return
        }

        lgaInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = "LGA Successfully Deleted"
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'lga.label', default: 'Lga'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
