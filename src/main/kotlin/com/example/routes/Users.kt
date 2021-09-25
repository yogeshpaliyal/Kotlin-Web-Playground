package com.example.routes

import com.example.model.Resource
import com.example.model.User
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*


fun Routing.usersApis(){
    get(USER_INFO) {
        call.respond(Resource.success(User("1", "Yogesh")))
    }
}