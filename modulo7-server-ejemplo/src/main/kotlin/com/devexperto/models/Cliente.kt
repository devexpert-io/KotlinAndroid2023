package com.devexperto.models

import kotlinx.serialization.Serializable

@Serializable
data class Cliente(val id: String, val firstName: String, val lastName: String, val email: String)

val clienteStorage = mutableListOf(
    Cliente("1", "Juan", "Perez", "juan@perez.com"),
    Cliente("2", "Pedro", "Gomez", "pedro@gomez.com"),
    Cliente("3", "Maria", "Gonzalez", "maria@gonzalez.com")
)