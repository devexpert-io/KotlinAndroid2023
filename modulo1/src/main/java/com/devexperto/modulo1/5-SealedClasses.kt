package com.devexperto.modulo1

sealed class Operation(val a: Double, val b: Double)
class Addition(a: Double, b: Double) : Operation(a, b)
class Subtraction(a: Double, b: Double) : Operation(a, b)
class Multiplication(a: Double, b: Double) : Operation(a, b)
class Division(a: Double, b: Double) : Operation(a, b)

fun calculate(operation: Operation): Double {
    return when (operation) {
        is Addition -> operation.a + operation.b
        is Subtraction -> operation.a - operation.b
        is Multiplication -> operation.a * operation.b
        is Division -> operation.a / operation.b
    }
}

/****/

sealed class Shape

class Circle(val radius: Double) : Shape()
class Rectangle(val width: Double, val height: Double) : Shape()
class Triangle(val base: Double, val height: Double) : Shape()

fun calculateArea(shape: Shape): Double {
    return when (shape) {
        is Circle -> Math.PI * shape.radius * shape.radius
        is Rectangle -> shape.width * shape.height
        is Triangle -> shape.base * shape.height / 2
    }
}