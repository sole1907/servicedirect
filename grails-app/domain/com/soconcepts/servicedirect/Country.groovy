package com.soconcepts.servicedirect

class Country {

    static hasMany = [states: State]
    
    String country;
    boolean active;
    Date created;
    Date modified;
    
    static constraints = {
        country(size: 1..100)
        modified nullable: true
    }
}
