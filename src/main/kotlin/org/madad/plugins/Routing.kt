package org.madad.plugins

import io.ktor.server.application.*
import io.ktor.server.routing.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import org.madad.routes.massages.responseMassage


fun Application.configureRouting() {
    routing {
        responseMassage()
    }
}
