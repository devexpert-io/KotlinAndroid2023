package com.devexperto.routes

import io.ktor.server.routing.*
import kotlinx.serialization.Serializable

@Serializable
data class Message(val message: String)

fun Route.clienteRoute() {

}
