package com.jebi.jebi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.jebi.jebi.ui.screen.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            var currentScreen by remember { mutableStateOf("login") }

            when (currentScreen) {
                "login" -> LoginScreen(
                    onLoginClick = { currentScreen = "notes" },
                    onSignupClick = { currentScreen = "signup" }
                )

                "signup" -> SignupScreen(
                    onSignupDone = { currentScreen = "notes" },
                    onLoginClick = { currentScreen = "login" }
                )

                "notes" -> NotesScreen(
                    onLogout = { currentScreen = "login" }
                )
            }
        }
    }
}