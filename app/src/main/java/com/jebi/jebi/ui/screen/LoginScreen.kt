package com.jebi.jebi.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(
    onLoginClick: () -> Unit,
    onSignupClick: () -> Unit
) {
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

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text("Jebi", fontSize = 28.sp)

            Spacer(modifier = Modifier.height(6.dp))

            Text("Your thoughts, beautifully organized.")

            Spacer(modifier = Modifier.height(20.dp))

            Card(
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(Color.White)
            ) {
                Column(modifier = Modifier.padding(20.dp)) {

                    Text("Log In", fontSize = 20.sp)

                    Spacer(modifier = Modifier.height(16.dp))

                    InputField("Email", email) { email = it }
                    Spacer(modifier = Modifier.height(12.dp))
                    InputField("Password", password, true) { password = it }

                    Spacer(modifier = Modifier.height(20.dp))

                    Button(
                        onClick = onLoginClick,
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(20.dp)
                    ) {
                        Text("Log In")
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            TextButton(onClick = onSignupClick) {
                Text("Don't have an account? Sign Up")
            }
        }
    }
}

@Composable
fun InputField(
    hint: String,
    value: String,
    isPassword: Boolean = false,
    onValueChange: (String) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF2F2F2), RoundedCornerShape(16.dp))
            .padding(12.dp)
    ) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            visualTransformation = if (isPassword) PasswordVisualTransformation() else androidx.compose.ui.text.input.VisualTransformation.None,
            modifier = Modifier.fillMaxWidth(),
            decorationBox = {
                if (value.isEmpty()) Text(hint, color = Color.Gray)
                it()
            }
        )
    }
}