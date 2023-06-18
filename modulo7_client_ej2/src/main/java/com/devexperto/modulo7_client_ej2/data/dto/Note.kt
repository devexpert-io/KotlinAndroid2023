package com.devexperto.modulo7_client_ej2.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class Note(val id: Long, var title: String, var description: String, var type: String): java.io.Serializable