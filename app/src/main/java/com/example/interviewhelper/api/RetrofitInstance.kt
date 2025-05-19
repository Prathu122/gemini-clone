package com.example.interviewhelper.api

import okhttp3.OkHttpClient
import okhttp3.Interceptor
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val BASE_URL = "https://cloudaicompanion.googleapis.com/" // Gemini API Base URL

    // Interceptor to add Authorization header
    private val authInterceptor = Interceptor { chain ->
        val request: Request = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer ")  // Replace with actual API key
            .addHeader("Content-Type", "application/json")
            .build()
        chain.proceed(request)
    }

    // OkHttpClient setup with the interceptor
    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(authInterceptor)
        .build()

    // Retrofit instance
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())  // Gson converter for parsing JSON
        .client(okHttpClient)  // Using OkHttp client
        .build()
}
