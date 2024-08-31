package com.example.guestink.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.guestink.android.screens.SignInScreen
import com.example.guestink.android.screens.SignUp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            MyApplicationTheme {

                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "main/{user}") {
                    composable("main/{user}") { entry ->
                        entry.arguments?.getString("user")?.let { user ->
                            MainActivity()
                        } ?: LaunchedEffect(null) {
                            navController.navigate("signIn")
                        }
                    }
                    composable("signIn") {
                        SignInScreen(
                            onSignUpClick = {
                                navController.navigate("signUp")
                            },
                            onRecoveryClick = {
                                navController.navigate("signUp")
                            }
                        )
                    }
                    composable("signUp") {
                        SignUp(

                        )
                    }
                }
            }
        }
    }


}
