package com.devexperto.modulo7_client_ej1.data.remote

import com.devexperto.modulo7_client_ej1.data.remote.dto.Cliente
import com.devexperto.modulo7_client_ej1.data.remote.dto.Message
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json

interface KtorClientService {
    suspend fun getClientes(): MutableList<Cliente>
    suspend fun addCliente(cliente: Cliente): Message
    suspend fun updateCliente(cliente: Cliente): Message
    suspend fun deleteCliente(id: Int): Message

    companion object {
        fun create(): KtorClientService {
            return KtorClientServiceImpl(
                HttpClient(OkHttp) {
                    install(ContentNegotiation) {
                        json()
                    }
                }
            )
        }

    }
}