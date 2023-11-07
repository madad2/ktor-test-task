package dev.madad.plugins

import dev.madad.routes.massages.massagesRouting
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        massagesRouting()
    }
}
