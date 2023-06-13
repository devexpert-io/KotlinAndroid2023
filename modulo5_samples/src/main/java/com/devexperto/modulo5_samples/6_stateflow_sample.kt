package com.devexperto.modulo5_samples

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

data class User(val name: String, val age: Int)

fun main(): Unit = runBlocking {
    val userFlow = MutableStateFlow(User("John Doe", 30))

    userFlow.value = User("Peter Richards", 40)

    val job = launch {
        userFlow.collect { user ->
            println("Nombre: ${user.name}, Edad: ${user.age}")
        }
    }

    delay(2000)

    userFlow.value = User("Jane Smith", 25)

    delay(2000)

    job.cancel()
}