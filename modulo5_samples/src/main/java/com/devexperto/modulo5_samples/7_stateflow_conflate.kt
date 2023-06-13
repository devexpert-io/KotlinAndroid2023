package com.devexperto.modulo5_samples

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking {
    val stateFlow = MutableStateFlow(0)

    val job = launch {
        stateFlow
            .collect { value ->
                println("Valor recibido: $value")
                delay(500) // Agregar un retraso de 500 ms para simular un procesamiento lento
            }
    }

    repeat(10) {
        stateFlow.value = it // Actualizar el valor del StateFlow
        delay(100) // Agregar un retraso de 100 ms entre actualizaciones
    }

    delay(2000)
    job.cancel()
}