package com.devexperto.routes

import com.devexperto.models.Cliente
import com.devexperto.models.clienteStorage
import com.devexperto.models.pedidosStorage
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable

@Serializable
data class Message(val message: String)

fun Route.clienteRoute() {
    route("/cliente") {
        get {
            if (clienteStorage.isNotEmpty()) {
                call.respond(clienteStorage)
            } else {
                call.respond(HttpStatusCode.NotFound, Message("No se encontraron clientes"))
            }
        }
        get("{id?}") {
            val id = call.parameters["id"] ?: return@get call.respond(
                HttpStatusCode.BadRequest, Message("Falta el identificador")
            )
            val cliente = clienteStorage.find { it.id == id } ?: return@get call.respond(
                HttpStatusCode.NotFound, Message("No hay un cliente con ID: $id")
            )
            call.respond(cliente)
        }
        post {
            val cliente = call.receive<Cliente>()
            clienteStorage.add(cliente)
            call.respond(HttpStatusCode.Created, Message("Cliente almacenado exitosamente"))
        }
        delete("{id?}") {
            val id = call.parameters["id"] ?: return@delete call.respond(HttpStatusCode.BadRequest, Message("Falta el identificador"))
            if (clienteStorage.removeIf { it.id == id }) {
                call.respond(HttpStatusCode.Accepted, Message("Cliente removido exitosamente"))
            } else {
                call.respond(HttpStatusCode.NotFound, Message("No encontrado"))
            }
        }
        put {
            val cliente = call.receive<Cliente>()
            val index = clienteStorage.indexOfFirst { it.id == cliente.id }
            if (index != -1) {
                clienteStorage[index] = cliente
                call.respond(HttpStatusCode.Accepted, Message("Cliente actualizado exitosamente"))
            } else {
                call.respond(HttpStatusCode.NotFound, Message("No encontrado"))
            }
        }
    }
}

fun Route.listaPedidosRoute() {
    get("/pedidos") {
        if (pedidosStorage.isNotEmpty()) {
            call.respond(pedidosStorage)
        } else {
            call.respond(HttpStatusCode.BadRequest, Message("No se encontraron pedidos"))
        }
    }
}