package com.example.onesignalexample

interface Source<out T> {
    fun nextT(): T
}
interface Comparable<in T> {
    operator fun compareTo(other: T): Int
}
fun demo(strs: Source<String>) {
    val obj : Source<Any> = strs
}

fun demo(x: Comparable<Number>) {
    x.compareTo(1.0) // 1.0 has type Double, which is a subtype of Number
    // Thus, you can assign x to a variable of type Comparable<Double>
    val y: Comparable<Double> = x // OK!
    val out = OutClass("string")
    val ref: OutClass<Any> = out
}

class OutClass<out T>(val value: T) {
    fun get(): T {
        return value
    }
}