package com.soconcepts.servicedirect

class ServiceProvider {

    static hasMany = [serviceSubcategories: ServiceSubcategory, serviceProviderReviews: ServiceProviderReview]
    
    Double longitude;
    Double latitude;
    String companyName;
    String picture;
    String about;
    Date modified;
    SecUser user;

    static constraints = {
        modified nullable: true
        longitude nullable: true
        latitude nullable: true
        about nullable: true
        picture nullable: true
    }
    
    static List<ServiceProvider> getList(long lgaId, long subCategoryId) {
        ServiceProvider.where {
            user.lga == Lga.load(lgaId) &&
            serviceSubcategories.id in subCategoryId
        }.list()
    }
    
}
