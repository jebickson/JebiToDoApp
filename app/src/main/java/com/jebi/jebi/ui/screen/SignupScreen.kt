package com.jebi.jebi.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SignupScreen(
    onSignupDone: () -> Unit,
    onLoginClick: () -> Unit
) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(Color(0xFFFF7A00), Color.White)
                )
            ),
        contentAlignment = Alignment.Center
    ) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Text("Jebi", fontSize = 28.sp)

            Spacer(modifier = Modifier.height(6.dp))

            Text("Create your account")

            Spacer(modifier = Modifier.height(20.dp))

            Card(
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(Color.White)
            ) {
                Column(modifier = Modifier.padding(20.dp)) {

                    Text("Sign Up", fontSize = 20.sp)

                    Spacer(modifier = Modifier.height(16.dp))

                    InputField("Full Name", name) { name = it }
                    Spacer(modifier = Modifier.height(12.dp))
                    InputField("Email Address", email) { email = it }
                    Spacer(modifier = Modifier.height(12.dp))
                    InputField("Create Password", password, true) { password = it }

                    Spacer(modifier = Modifier.height(20.dp))

                    Button(
                        onClick = onSignupDone,
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(20.dp)
                    ) {
                        Text("Create Account")
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            TextButton(onClick = onLoginClick) {
                Text("Already have an account? Log In")
            }
        }
    }
}