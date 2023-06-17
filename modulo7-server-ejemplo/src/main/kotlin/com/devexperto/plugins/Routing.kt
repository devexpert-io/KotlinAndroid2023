package com.devexperto.plugins

import com.devexperto.routes.*
import io.ktor.server.routing.*
import io.ktor.server.application.*

fun Application.configureRouting() {
    routing {
        clienteRoute()
    }
}
