package com.example.chucknorrisjokes

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.Request
import javax.inject.Inject


class ChuckNorrisApi @Inject constructor(
    private val okHttpClient: OkHttpClient,
    private val json: Json
) {

    suspend fun getRandomJoke(): Joke {
        return withContext(Dispatchers.IO) {
            val request = Request.Builder()
                .url("https://api.chucknorris.io/jokes/random")
                .build()

            val call = okHttpClient.newCall(request)
            val response = call.execute()

            if (!response.isSuccessful) throw Exception("Response code ${response.code}")

            val jokeString = response.body?.string() ?: throw Exception("Body is empty")

            return@withContext json.decodeFromString(Joke.serializer(), jokeString)
        }
    }
}