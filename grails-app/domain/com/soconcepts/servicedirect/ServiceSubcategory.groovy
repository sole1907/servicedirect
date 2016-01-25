package com.soconcepts.servicedirect

class ServiceSubcategory {

    static hasMany = [serviceProviders: ServiceProvider]
    static belongsTo = [ServiceProvider]
    
    String subcategory;
    boolean active;
    Date created;
    Date modified;
    ServiceCategory serviceCategory
     
    static constraints = {
        modified nullable: true
    }
    
    static def categorySubsByCatId(Long catId) {
        System.out.println("cat id " + catId)
        if (catId != null) {
            ServiceSubcategory.where { serviceCategory.id == catId }.list()
        } else {
            new ArrayList()
        }
    }
    
    boolean equals(Object o) {
        if (o == null) return false
        if (o instanceof ServiceSubcategory) {
            System.out.println("o is inatance " + o)
            return id == o.id
        } else {
            System.out.println("o is not inatance " + o)
            return id == o
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
