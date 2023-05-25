package com.devexperto.modulo1

fun <T, R> with2(receiver: T, block: T.() -> R): R {
    return receiver.block()
}

fun <T> T.apply2(block: T.() -> Unit): T {
    block()
    return this
}

fun <T, R> T.let2(block: (T) -> R): R {
    return block(this)
}
