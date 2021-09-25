package com.example.routes

import com.example.auth.JwtConfig
import com.example.model.Resource
import com.example.model.User
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*


/**
 * Define authentication api's without token
 */
fun Routing.authApis(){
    get(LOGIN){
        if (call.request.queryParameters.contains("name").not()){
            call.respondText("Please enter name")
            return@get
        }
        val name = call.request.queryParameters.get("name") ?: ""

        val hashmap = HashMap<String,Any>()
        hashmap["token"] = JwtConfig.makeToken(User("1",name))
        hashmap["user"] = User("1", name)

        call.respond(Resource.success(hashmap))
    }
}