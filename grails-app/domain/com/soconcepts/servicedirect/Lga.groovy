package com.soconcepts.servicedirect

class Lga {

    static hasMany = [secUsers: SecUser]
    static belongsTo = [state: State]
    
    String lga;
    Date created;
    Date modified;
    boolean active;
    
    static constraints = {
        lga(size: 1..45)
        modified nullable: true
    }
    
    static def stateLgasByStateId(Long stateId) {
        if (stateId != null) {
            Lga.where { state.id == stateId }.list()
        } else {
            new ArrayList()
        }
    }
    def beforeUpdate() {
        modified = new Date()
    }
    
    def beforeValidate() {
        if (created == null) {
            created = new Date()
        }
    }
    
}
