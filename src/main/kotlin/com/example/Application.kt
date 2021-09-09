package com.example

import com.example.model.Resource
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.http.*
import io.ktor.response.*

fun main() {
    embeddedServer(Netty, port = System.getenv("PORT").toInt()) {
        install(StatusPages){
            exception<Throwable>{ cause ->
                call.respond(HttpStatusCode.InternalServerError,Resource.error<Unit>("Message ${cause.localizedMessage}"))
            }
        }
        install(ContentNegotiation) {
            gson {
                setPrettyPrinting()
                setLenient()
            }
        }
        //configureSecurity()
        configureRouting()
    }.start(wait = true)
}
