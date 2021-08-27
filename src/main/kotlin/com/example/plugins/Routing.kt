package com.example.plugins

import com.auth0.jwt.JWT
import com.example.auth.JwtConfig
import com.example.model.Resource
import com.example.model.User
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*

fun Application.configureRouting() {

    routing {
        get("/") {
                call.respondText("Hello World !")
            }

        get("/login"){
            if (call.request.queryParameters.contains("name").not()){
                call.respondText("Please enter name")
                return@get
            }
            val name = call.request.queryParameters.get("name") ?: ""
            call.respond(Resource.success(hashMapOf("token" to JwtConfig.makeToken(User("1",name)), "user" to User("1",name))))
        }
    }
}
