package com.soconcepts.servicedirect

class ServiceProviderReview {

    Double rating;
    String comment;
    SecUser ratedBy;
    ServiceProvider serviceProvider;
    String raterName
    Date created
    
    static constraints = {
        comment nullable: true
        ratedBy nullable: true
        raterName nullable: true
    }
    
    def beforeValidate() {
        if (created == null) {
            created = new Date()
        }
    }
    
    static def sumServiceProviderRatings(Long id) {
        ServiceProviderReview.executeQuery(
   'select sum(rating) from ServiceProviderReview spr where spr.serviceProvider.id=:serviceProviderId',
            [serviceProviderId: id])[0]
    }
}
