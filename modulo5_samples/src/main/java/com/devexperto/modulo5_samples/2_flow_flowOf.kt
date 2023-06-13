package com.devexperto.modulo5_samples

import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

fun main() {
    val flow = flowOf(1, 2, 3, 4)

    runBlocking {
        flow.collect { println(it) }
    }
}