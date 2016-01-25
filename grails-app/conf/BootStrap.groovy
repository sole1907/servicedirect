
import com.soconcepts.servicedirect.Country
import com.soconcepts.servicedirect.Lga
import com.soconcepts.servicedirect.SecRole
import com.soconcepts.servicedirect.SecUser
import com.soconcepts.servicedirect.SecUserSecRole
import com.soconcepts.servicedirect.State

class BootStrap {

    def init = { servletContext ->
        if (!Country.count()) {
            def userRole = SecRole.findByAuthority('ROLE_USER') ?: new SecRole(authority: 'ROLE_USER').save(failOnError: true)
            def serviceProviderRole = SecRole.findByAuthority('ROLE_SERVICE_PROVIDER') ?: new SecRole(authority: 'ROLE_SERVICE_PROVIDER').save(failOnError: true)
            def adminRole = SecRole.findByAuthority('ROLE_ADMIN') ?: new SecRole(authority: 'ROLE_ADMIN').save(failOnError: true)
        
            def nigeria = new Country(country:"Nigeria", active:true, created: new Date()).save(failOnError: true)
        
            def lagos = new State(country:nigeria, state:"Lagos", active:true, created: new Date()).save(failOnError: true)
        
            def amuwo = new Lga(state:lagos, lga:"Amuwo Odofin", active:true, created: new Date()).save(failOnError: true)
        
            def adminUser = SecUser.findByUsername('admin@servicedirect.com.ng') ?: new SecUser(
                username: 'admin@servicedirect.com.ng',
                password: 'servicedirect1',
                lastname: 'Administrator',
                firstname: 'ServiceDirect',
                address: 'Lagos',
                sex: 'Male',
                lga: amuwo,
                mobile: '08012345678',
                activationcode: '984379fojdlrehoiyo8jhfodjreoijr',
                created: new Date(),
                enabled: true).save(failOnError: true)

            if (!adminUser.authorities.contains(adminRole)) {
                SecUserSecRole.create adminUser, adminRole
            }
        }
    }
    def destroy = {
    }
}
