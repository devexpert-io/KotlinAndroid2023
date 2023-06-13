package com.devexperto.modulo5_samples

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main(): Unit = runBlocking {
    val temperatureFlow = createTemperatureFlow()

    val job = launch {
        temperatureFlow.collect { temperature ->
            println("Temperatura actual: $temperature")
        }
    }

    delay(5000)
    job.cancel()
}

fun createTemperatureFlow(): Flow<Int> = flow {
    var temperature = 25
    while (true) {
        emit(temperature)
        delay(1000)

        val randomChange = (Math.random() * 4 - 2).toInt()
        temperature += randomChange
    }
}
