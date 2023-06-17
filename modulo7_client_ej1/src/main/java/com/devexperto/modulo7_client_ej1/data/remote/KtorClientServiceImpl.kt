package com.devexperto.modulo7_client_ej1.data.remote

import com.devexperto.modulo7_client_ej1.data.remote.dto.Cliente
import com.devexperto.modulo7_client_ej1.data.remote.dto.Message
import io.ktor.client.*
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.request.*
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.contentType

class KtorClientServiceImpl(private val client: HttpClient): KtorClientService {

    override suspend fun getClientes(): MutableList<Cliente> {
        return try {
            client.request(HttpRoutes.ENDPOINT_CLIENTES){
                method = HttpMethod.Get
            }.body()
        } catch (e: ClientRequestException) {
            throw e
        }
    }

    override suspend fun addCliente(cliente: Cliente): Message {
        return try {
            client.request(HttpRoutes.ENDPOINT_CLIENTES) {
                method = HttpMethod.Post
                contentType(ContentType.Application.Json)
                setBody(cliente)
            }.body()
        } catch (e: ClientRequestException) {
            throw e
        }
    }

    override suspend fun updateCliente(cliente: Cliente): Message {
        return try {
            client.request(HttpRoutes.ENDPOINT_CLIENTES) {
                method = HttpMethod.Put
                contentType(ContentType.Application.Json)
                setBody(cliente)
            }.body()
        } catch (e: ClientRequestException) {
            throw e
        }
    }

    override suspend fun deleteCliente(id: Int): Message {
        return try {
            client.request("${HttpRoutes.ENDPOINT_CLIENTES}/$id"){
                method = HttpMethod.Delete
            }.body()
        } catch (e: ClientRequestException) {
            throw e
        }
    }


}