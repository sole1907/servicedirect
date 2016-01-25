package com.soconcepts.servicedirect

class State {

    static hasMany = [lgas: Lga]
    static belongsTo = [country: Country]
    
    String state;
    Date created;
    Date modified;
    boolean active;
    
    static constraints = {
        state(size: 1..45)
        modified nullable: true
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
