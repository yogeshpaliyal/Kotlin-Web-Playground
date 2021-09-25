package com.example.routes

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Routing.generalApis(){
    get("/") {
        call.respondText("Hello World! Welcome to My First Kotlin Backend Code")
    }
}