package com.devexperto.modulo5_samples

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main(): Unit = runBlocking {

    val sharedFlow = MutableSharedFlow<Int>()
    sharedFlow.emit(1)

    val job = launch {
        sharedFlow.collect { value ->
            println("Valor recibido: $value")
        }
    }

    delay(2000)

    sharedFlow.emit(2)
    sharedFlow.emit(3)

    delay(2000)

    sharedFlow.emit(4)

    delay(2000)

    job.cancel()
}