package com.example.plugins

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.example.auth.JwtConfig
import com.example.model.Resource
import com.example.model.User
import com.example.routes.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*

fun Application.configureRouting() {

    routing {

        intercept(ApplicationCallPipeline.Setup){
            print(call.request.path())
            if (!NON_AUTH_APIS.contains(call.request.path())){
                // Authenticate the API
                val token = call.request.headers.get("token")
                if(token.isNullOrEmpty()){
                    call.respond(Resource.error<Unit>("Invalid token"))
                    return@intercept finish() // this line with return the intercept and not call the actual api
                }
            }
        }

        generalApis()
        authApis()
        usersApis()
    }
}
