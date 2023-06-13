package com.devexperto.modulo5_samples

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    makeFlow()
        .filter { it % 2 == 0 }     // Operador intermedio
        .map { "Value is $it" }     // Operador intermedio
        .collect{ println(it)  }    // Operador terminal
}

private fun makeFlow() = flow {
    for (i in (1..1000)) {
        delay(200)
        emit(i)
    }
}