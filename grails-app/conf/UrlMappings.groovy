class UrlMappings {

    static mappings = {
        "/api/$controller/$action?/$id?/$code?(.$format)?"{
            constraints {
                
                // apply constraints here
            }
        }
        
        "/api/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        
            "/$controller/$action?/$id?/$code?(.$format)?"{
            constraints {
                
                // apply constraints here
            }
        }

        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        
        "/"(view:"/index")
        "500"(view:'/error')
    }
}
