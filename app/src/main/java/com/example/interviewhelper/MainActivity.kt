package com.example.interviewhelper

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.interviewhelper.viewmodel.GeminiViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    GeminiScreen()
                }
            }
        }
    }
}

@Composable
fun GeminiScreen(viewModel: GeminiViewModel = viewModel()) {
    val response by viewModel.response.collectAsState()

    var input by remember { mutableStateOf("What is AI?") }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        TextField(
            value = input,
            onValueChange = { input = it },
            label = { Text("Ask a question") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { viewModel.getResponse(input) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ask Gemini")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = response)
    }
}





