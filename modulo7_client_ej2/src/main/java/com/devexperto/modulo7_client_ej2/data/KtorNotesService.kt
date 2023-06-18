package com.devexperto.modulo7_client_ej2.data

import com.devexperto.modulo7_client_ej2.data.dto.Note
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json

interface KtorClientService {
    suspend fun getNotes(): MutableList<Note>
    suspend fun addNote(note: Note): Any
    suspend fun updateNote(note: Note): Any
    suspend fun deleteNote(note: Note): Any

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