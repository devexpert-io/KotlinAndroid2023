package com.devexperto.modulo1

fun <T> printElements(array: Array<T>) {
    for (element in array) {
        println(element)
    }
}

fun <T : Comparable<T>> maxValue(a: T, b: T): T {
    return if (a > b) a else b
}