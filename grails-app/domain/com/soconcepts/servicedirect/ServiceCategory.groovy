package com.soconcepts.servicedirect

class ServiceCategory {

    static hasMany = [serviceSubcategories: ServiceSubcategory]
    
    String category;
    boolean active;
    Date created;
    Date modified;
    
    static constraints = {
        modified nullable: true
    }
    
    static mapping = {
        serviceSubcategories(cascade: "all-delete-orphan")
    }
}
