package com.soconcepts.servicedirect



import grails.test.mixin.*
import spock.lang.*

@TestFor(LgaController)
@Mock(Lga)
class LgaControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.lgaInstanceList
            model.lgaInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.lgaInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            def lga = new Lga()
            lga.validate()
            controller.save(lga)

        then:"The create view is rendered again with the correct model"
            model.lgaInstance!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            lga = new Lga(params)

            controller.save(lga)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/lga/show/1'
            controller.flash.message != null
            Lga.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def lga = new Lga(params)
            controller.show(lga)

        then:"A model is populated containing the domain instance"
            model.lgaInstance == lga
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def lga = new Lga(params)
            controller.edit(lga)

        then:"A model is populated containing the domain instance"
            model.lgaInstance == lga
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/lga/index'
            flash.message != null


        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def lga = new Lga()
            lga.validate()
            controller.update(lga)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.lgaInstance == lga

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            lga = new Lga(params).save(flush: true)
            controller.update(lga)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/lga/show/$lga.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/lga/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def lga = new Lga(params).save(flush: true)

        then:"It exists"
            Lga.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(lga)

        then:"The instance is deleted"
            Lga.count() == 0
            response.redirectedUrl == '/lga/index'
            flash.message != null
    }
}
