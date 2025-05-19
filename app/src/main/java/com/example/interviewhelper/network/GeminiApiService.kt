package com.example.interviewhelper.network

import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.Call

data class GeminiRequest(
    val contents: List<Content>
)

data class Content(
    val parts: List<Part>
)

data class Part(
    val text: String
)

data class GeminiResponse(
    val candidates: List<GeminiCandidate>
)

data class GeminiCandidate(
    val content: Content
)

interface GeminiApiService {
    @POST("v1beta/models/gemini-pro:generateContent")
    fun getGeminiResponse(@Body request: GeminiRequest): Call<GeminiResponse>
}
