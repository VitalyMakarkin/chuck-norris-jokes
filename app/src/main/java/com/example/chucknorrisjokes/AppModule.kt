package com.example.chucknorrisjokes

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideJson(): Json = Json {
        this.ignoreUnknownKeys = true
        this.isLenient = false
    }
}