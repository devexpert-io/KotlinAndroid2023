package com.devexperto.modulo1

import kotlin.properties.Delegates

class Database {
    val connection: Connection by lazy {
        Connection()
    }
}

class Connection

/****/

class TemperatureSensor {
    var temperature: Double by Delegates.observable(0.0) { _, oldValue, newValue ->
        println("la temperatura cambió de $oldValue a $newValue")
    }
}

/****/

class Counter {
    var value: Int by Delegates.vetoable(0) { _, oldValue, newValue ->
        if (newValue > 0) {
            true
        } else {
            println("El valor $newValue no es válido, se mantiene el valor $oldValue")
            false
        }
    }
}