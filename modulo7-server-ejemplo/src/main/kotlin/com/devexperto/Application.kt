package com.devexperto

import io.ktor.server.application.*
import com.devexperto.plugins.*
import io.ktor.server.netty.*

fun main(args: Array<String>): Unit =
    EngineMain.main(args)

fun Application.module() {
    configureSerialization()
    configureRouting()
}
