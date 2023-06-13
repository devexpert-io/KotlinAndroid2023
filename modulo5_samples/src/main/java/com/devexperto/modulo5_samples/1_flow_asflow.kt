package com.devexperto.modulo5_samples

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.runBlocking

fun main() {
    val flow = listOf(1, 2, 3, 4).asFlow()

    runBlocking {
        flow.collect { println(it) }
    }
}