package dev.madad.routes.massages

import dev.madad.models.Mail
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.Duration


fun Route.massagesRouting() {
    route("/massage") {
        get("1") {
            call.respondText("Massage1 printing")
            printMassage1(60_000L)
        }
        get("2") {
            call.respondText("Massage2 printing")
            launch {
                printMassage2(300_000L)
            }
        }
        post {
            val mail = call.receive<Mail>()
            call.respondText("Mail $mail sending...")
            launch {
                sendMail(mail)
            }
        }
    }
}

suspend fun printMassage1(time: Long) {
    while (true) {
        println("Прошла одна минута")
        delay(time)
    }
}

suspend fun printMassage2(time: Long) {
    while (true) {
        delay(time)
        println("Прошло пять минут и тебе пора меня выключить")
    }
}

suspend fun sendMail(mail: Mail) {
    val currentTime = LocalDateTime.now()
    val sendTime = currentTime.plusDays(1).with(LocalTime.of(8, 0))
    val delayUntil8 = Duration.between(currentTime, sendTime)

    delay(delayUntil8.toMillis())

    while (true) {
        println("Возьми меня на работу. Мой email: ${mail.text}")
        delay(24 * 60 * 60 * 1000)
    }
}