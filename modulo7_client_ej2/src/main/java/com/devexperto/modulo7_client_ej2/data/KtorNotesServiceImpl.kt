package com.devexperto.modulo7_client_ej2.data

import com.devexperto.modulo7_client_ej2.data.dto.Note
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.contentType

class KtorClientServiceImpl(private val client: HttpClient): KtorClientService {
    override suspend fun getNotes(): MutableList<Note> {
        return try {
            client.request(HttpRoutes.ENDPOINT_NOTAS){
                method = HttpMethod.Get
            }.body()
        } catch (e: ClientRequestException) {
            throw e
        }
    }

    override suspend fun addNote(note: Note): Any {
        return try {
            client.request(HttpRoutes.ENDPOINT_NOTAS) {
                method = HttpMethod.Post
                contentType(ContentType.Application.Json)
                setBody(note)
            }.body()
        } catch (e: ClientRequestException) {
            throw e
        }
    }

    override suspend fun updateNote(note: Note): Any {
        return try {
            client.request(HttpRoutes.ENDPOINT_NOTAS) {
                method = HttpMethod.Put
                contentType(ContentType.Application.Json)
                setBody(note)
            }.body()
        } catch (e: ClientRequestException) {
            throw e
        }
    }

    override suspend fun deleteNote(note: Note): Any {
        return try {
            client.request("${HttpRoutes.ENDPOINT_NOTAS}/${note.id}"){
                method = HttpMethod.Delete
            }.body()
        } catch (e: ClientRequestException) {
            throw e
        }
    }

}