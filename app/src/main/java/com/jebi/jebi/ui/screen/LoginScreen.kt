package com.jebi.jebi.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen(
    onLogin: () -> Unit,
    onSignupClick: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Text("Login", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = email, onValueChange = { email = it }, label = { Text("Email") })

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(value = password, onValueChange = { password = it }, label = { Text("Password") })

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = onLogin, modifier = Modifier.fillMaxWidth()) {
            Text("Login")
        }

        TextButton(onClick = onSignupClick) {
            Text("Don't have account? Sign Up")
        }
    }
}