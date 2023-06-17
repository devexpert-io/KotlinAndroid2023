package com.devexperto.modulo7_client_ej1.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class Cliente(val id: String, var firstName: String, var lastName: String, var email: String): java.io.Serializable

@Serializable
data class Message(val message: String)
