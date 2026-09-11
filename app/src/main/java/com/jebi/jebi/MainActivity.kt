package com.jebi.jebi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.jebi.jebi.ui.screen.LoginScreen
import com.jebi.jebi.ui.screen.SignupScreen
import com.jebi.jebi.ui.screen.NotesScreen
import com.jebi.jebi.ui.theme.JebiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            JebiTheme {
                var currentScreen by remember { mutableStateOf("login") }

                when (currentScreen) {
                    "login" -> LoginScreen(
                        onLogin = { currentScreen = "notes" },
                        onSignupClick = { currentScreen = "signup" }
                    )

                    "signup" -> SignupScreen(
                        onSignup = { currentScreen = "notes" },
                        onLoginClick = { currentScreen = "login" }
                    )

                    "notes" -> NotesScreen(
                        onLogout = { currentScreen = "login" }
                    )
                }
            }
        }
    }
}