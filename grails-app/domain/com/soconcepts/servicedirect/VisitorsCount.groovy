package com.soconcepts.servicedirect

class VisitorsCount {

    Date date;
    int count;
    
    static constraints = {
    }

    def saveCount() {
        this.save flush:true
    }
}
