package com.devexperto.modulo5_samples

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() {
    val flow = flow {
        for (i in (1..4)) {
            delay(200)
            emit(i)
        }
    }

    runBlocking {
        flow.collect { println(it) }
    }
}