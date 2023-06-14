package com.devexperto.modulo5_samples

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*

fun main(): Unit = runBlocking {
    val channel = Channel<Int>()

    launch {
        repeat(20) { value ->
            channel.send(value + 1)
            println("Valor enviado: ${value + 1}")
            delay(500)
        }
        channel.close()
    }

    for (value in channel) {
        println("Valor recibido: $value")
    }
}