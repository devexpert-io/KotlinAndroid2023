package com.devexperto.kotlinexpert

import com.devexperto.kotlinexpert.plugins.configureRouting
import com.devexperto.kotlinexpert.plugins.configureSerialization
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.cors.routing.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureRouting()
        configureSerialization()
        install(CORS) {
            allowMethod(HttpMethod.Delete)
            allowMethod(HttpMethod.Put)
            allowHeader(HttpHeaders.AccessControlAllowOrigin)
            allowNonSimpleContentTypes = true
            anyHost()
        }
    }.start(wait = true)
}
