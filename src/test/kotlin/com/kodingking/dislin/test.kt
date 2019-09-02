package com.kodingking.dislin

suspend fun main() {
    val token = System.getenv("token") ?: return
    val dislin = Dislin(token)
    dislin.connect()
}