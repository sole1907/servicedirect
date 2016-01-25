package com.soconcepts.servicedirect



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Transactional(readOnly = true)
@Secured(['ROLE_ADMIN', 'ROLE_SERVICE_PROVIDER', 'ROLE_USER'])
class ProfileViewsController {

    def springSecurityService
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    /*def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ProfileViews.list(params), model:[profileViewsInstanceCount: ProfileViews.count()]
    }*/
    
    @Secured(['ROLE_ADMIN', 'ROLE_SERVICE_PROVIDER'])
    def profileviews(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        def serviceProvider = ServiceProvider.findByUser(springSecurityService.currentUser)
        respond ProfileViews.findAllByServiceProvider(serviceProvider, params), model:[profileViewsInstanceCount: ProfileViews.countByServiceProvider(serviceProvider)]
    }
    
    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def recentviews(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ProfileViews.findAllByUser(springSecurityService.currentUser, params), model:[profileViewsInstanceCount: ProfileViews.countByUser(springSecurityService.currentUser)]
    }

    /*def show(ProfileViews profileViewsInstance) {
        respond profileViewsInstance
    }

    def create() {
        respond new ProfileViews(params)
    }

    @Transactional
    def save(ProfileViews profileViewsInstance) {
        if (profileViewsInstance == null) {
            notFound()
            return
        }

        if (profileViewsInstance.hasErrors()) {
            respond profileViewsInstance.errors, view:'create'
            return
        }

        profileViewsInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'profileViews.label', default: 'ProfileViews'), profileViewsInstance.id])
                redirect profileViewsInstance
            }
            '*' { respond profileViewsInstance, [status: CREATED] }
        }
    }

    def edit(ProfileViews profileViewsInstance) {
        respond profileViewsInstance
    }

    @Transactional
    def update(ProfileViews profileViewsInstance) {
        if (profileViewsInstance == null) {
            notFound()
            return
        }

        if (profileViewsInstance.hasErrors()) {
            respond profileViewsInstance.errors, view:'edit'
            return
        }

        profileViewsInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ProfileViews.label', default: 'ProfileViews'), profileViewsInstance.id])
                redirect profileViewsInstance
            }
            '*'{ respond profileViewsInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(ProfileViews profileViewsInstance) {

        if (profileViewsInstance == null) {
            notFound()
            return
        }

        profileViewsInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ProfileViews.label', default: 'ProfileViews'), profileViewsInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }*/

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'profileViews.label', default: 'ProfileViews'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
