package dev.madad.models

import kotlinx.serialization.Serializable

@Serializable
data class Mail(
    val to: String,
    val subject: String,
    val text: String
)
