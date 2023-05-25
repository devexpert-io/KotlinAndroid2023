package com.devexperto.modulo1

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)

    val result = numbers.asSequence()
        .filter { it % 2 == 0 && it % 3 == 0 }
        .map { it * it }
        .sum()

    println(result)
}