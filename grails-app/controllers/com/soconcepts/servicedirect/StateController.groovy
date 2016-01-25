package com.soconcepts.servicedirect



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Transactional(readOnly = true)
@Secured(['ROLE_ADMIN'])
class StateController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond State.list(params), model:[stateInstanceCount: State.count()]
    }

    def show(State stateInstance) {
        respond stateInstance
    }

    def create() {
        respond new State(params)
    }

    @Transactional
    def save(State stateInstance) {
        if (stateInstance == null) {
            notFound()
            return
        }

        if (stateInstance.hasErrors()) {
            respond stateInstance.errors, view:'create'
            return
        }

        stateInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = "State Successfully Added"
                redirect(action: 'index')
            }
            '*' { respond stateInstance, [status: CREATED] }
        }
    }

    def edit(State stateInstance) {
        respond stateInstance
    }

    @Transactional
    def update(State stateInstance) {
        if (stateInstance == null) {
            notFound()
            return
        }

        if (stateInstance.hasErrors()) {
            respond stateInstance.errors, view:'edit'
            return
        }

        stateInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = "State Successfully Updated"
                redirect(action: 'index')
            }
            '*'{ respond stateInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(State stateInstance) {

        if (stateInstance == null) {
            notFound()
            return
        }

        stateInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = "State Successfully Deleted"
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }
    
    @Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
    def stateSelected() {
        def state = State.findById(params.id)
        render g.select(noSelection: ['':'Select LGA ...'], optionKey: 'id', optionValue: 'lga', from: state.lgas, id: 'lga', name: "lga")
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'state.label', default: 'State'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
