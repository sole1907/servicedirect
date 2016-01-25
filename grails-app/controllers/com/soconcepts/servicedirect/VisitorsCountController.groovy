package com.soconcepts.servicedirect



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Transactional(readOnly = true)
@Secured(['ROLE_ADMIN'])
class VisitorsCountController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond VisitorsCount.list(params), model:[visitorsCountInstanceCount: VisitorsCount.count()]
    }

    def show(VisitorsCount visitorsCountInstance) {
        respond visitorsCountInstance
    }

    def create() {
        respond new VisitorsCount(params)
    }

    @Transactional
    def save(VisitorsCount visitorsCountInstance) {
        if (visitorsCountInstance == null) {
            notFound()
            return
        }

        if (visitorsCountInstance.hasErrors()) {
            respond visitorsCountInstance.errors, view:'create'
            return
        }

        visitorsCountInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'visitorsCount.label', default: 'VisitorsCount'), visitorsCountInstance.id])
                redirect visitorsCountInstance
            }
            '*' { respond visitorsCountInstance, [status: CREATED] }
        }
    }

    def edit(VisitorsCount visitorsCountInstance) {
        respond visitorsCountInstance
    }

    @Transactional
    def update(VisitorsCount visitorsCountInstance) {
        if (visitorsCountInstance == null) {
            notFound()
            return
        }

        if (visitorsCountInstance.hasErrors()) {
            respond visitorsCountInstance.errors, view:'edit'
            return
        }

        visitorsCountInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'VisitorsCount.label', default: 'VisitorsCount'), visitorsCountInstance.id])
                redirect visitorsCountInstance
            }
            '*'{ respond visitorsCountInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(VisitorsCount visitorsCountInstance) {

        if (visitorsCountInstance == null) {
            notFound()
            return
        }

        visitorsCountInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'VisitorsCount.label', default: 'VisitorsCount'), visitorsCountInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'visitorsCount.label', default: 'VisitorsCount'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
