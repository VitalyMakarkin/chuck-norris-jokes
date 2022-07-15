package com.example.chucknorrisjokes

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Joke(
    @SerialName("id")
    val id: String,

    @SerialName("value")
    val value: String
)
