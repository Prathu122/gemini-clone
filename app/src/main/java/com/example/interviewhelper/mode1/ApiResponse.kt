package com.example.interviewhelper.model

data class ApiResponse(
    val candidates: List<Candidate>
)

data class Candidate(
    val content: Content
)
