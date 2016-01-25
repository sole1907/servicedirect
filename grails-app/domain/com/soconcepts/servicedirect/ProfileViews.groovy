package com.soconcepts.servicedirect

class ProfileViews {

    Date created
    SecUser user
    ServiceProvider serviceProvider
    
    static constraints = {
        user nullable: true
    }
}
