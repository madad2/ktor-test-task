package org.madad.routes.massages

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

fun Route.responseMassage() {
    route("massages") {
        get {

        }
        get("1") {
            call.respondText("Running task1")
            printMassage1()
        }
        get("2") {
            call.respondText("Running task2")
            launch {
                printMassage1()
            }
            launch {
                printMassage2()
            }
        }
    }
}

suspend fun printMassage1() {
    while (true) {
        println("Прошла одна минута")
        delay(1000L)
    }
}

suspend fun printMassage2() {
    while (true) {
        delay(5000L)
        println("Прошло пять минут и тебе пора меня выключить")
    }
}
