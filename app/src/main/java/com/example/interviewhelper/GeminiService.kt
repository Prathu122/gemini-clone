package com.example.interviewhelper.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GeminiService {
    @GET("/v1/projects/YOUR_PROJECT_ID/locations/YOUR_LOCATION") // Replace with actual
    fun getGeminiResponse(
        @Query("question") question: String
    ): Call<GeminiResponse>
}

