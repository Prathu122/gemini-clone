package com.example.interviewhelper.repository

import com.example.interviewhelper.network.RetrofitClient
import com.example.interviewhelper.network.GeminiApiService
import com.example.interviewhelper.network.GeminiRequest
import com.example.interviewhelper.network.GeminiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.interviewhelper.api.RetrofitInstance

class GeminiRepository {

    // Corrected this line
    private val apiService = RetrofitInstance.retrofit.create(GeminiApiService::class.java)

    fun getGeminiResponse(request: GeminiRequest, onResponse: (GeminiResponse?) -> Unit) {
        val call = apiService.getGeminiResponse(request)

        call.enqueue(object : Callback<GeminiResponse> {
            override fun onResponse(call: Call<GeminiResponse>, response: Response<GeminiResponse>) {
                if (response.isSuccessful) {
                    onResponse(response.body())
                } else {
                    // Handle error
                }
            }

            override fun onFailure(call: Call<GeminiResponse>, t: Throwable) {
                // Handle failure
            }
        })
    }
}

