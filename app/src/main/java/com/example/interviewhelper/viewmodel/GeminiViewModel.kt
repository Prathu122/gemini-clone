package com.example.interviewhelper.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.interviewhelper.api.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class GeminiViewModel : ViewModel() {

    private val _response = MutableStateFlow<String>("")
    val response: StateFlow<String> = _response

    fun getResponse(question: String) {
        viewModelScope.launch {
            try {
                val call = RetrofitInstance.api.getGeminiResponse(question)
                val result = call.execute()
                if (result.isSuccessful) {
                    _response.value = result.body()?.answer ?: "No answer found"
                } else {
                    _response.value = "Error: ${result.message()}"
                }
            } catch (e: Exception) {
                _response.value = "Exception: ${e.message}"
            }
        }
    }
}




