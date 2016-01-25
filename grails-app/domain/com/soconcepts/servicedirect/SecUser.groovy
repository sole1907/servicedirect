package com.soconcepts.servicedirect

import com.soconcepts.servicedirect.utils.UtilityMethods;

class SecUser {

    static belongsTo = [lga: Lga]
    
    transient springSecurityService

    String username
    String password
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired
    String lastname;
    String firstname;
    String address;
    String sex;
    String mobile;
    Date created;
    Date modified;
    String activationcode;
    boolean active;
    

    static transients = ['springSecurityService']

    static constraints = {
        username email: true, blank: false, unique: true
        password blank: false
        lastname(size: 1..45)
        firstname(size: 1..45)
        address(size: 1..255)
        sex size: 1..6, nullable: true
        modified nullable: true
    }

    static mapping = {
        password column: '`password`'
    }

    Set<SecRole> getAuthorities() {
        SecUserSecRole.findAllBySecUser(this).collect { it.secRole }
    }

    def beforeInsert() {
        encodePassword()
    }

    def beforeUpdate() {
        if (isDirty('password')) {
            encodePassword()
        }
    }

    protected void encodePassword() {
        password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
    }
    
    def beforeValidate() {
        if (created == null) {
            created = new Date()
        }
        
        if (activationcode == null) {
            activationcode = UtilityMethods.getMD5("" + new Random().nextLong())
        }
    }
}
