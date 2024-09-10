package com.example.guestink.android

import RequestLocationPermission
import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.guestink.android.models.User
import com.example.guestink.android.network.orionServices
import com.example.guestink.android.screens.RecoveryAccount
import com.example.guestink.android.screens.RegisterAddressUser
import com.example.guestink.android.screens.SignInScreen
import com.example.guestink.android.screens.SignUp
import com.example.guestink.android.screens.panel.Home
import com.example.guestink.android.services.UserResponse
import com.example.guestink.android.services.postRegisterUser
import com.example.guestink.android.utils.GetCurrentLocation
import com.google.gson.Gson
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var userLocation = Pair(0.0, 0.0);
            RequestLocationPermission(
                onPermissionGranted = { /*TODO*/ },
                onPermissionDenied = { /*TODO*/ }) {
            }
            GetCurrentLocation(
                onGetCurrentLocationSuccess = {
                    userLocation = it
                },
                onGetCurrentLocationFailed = {},
                context = this
            )
            val orionServices by lazy {
                orionServices()
            }

            MyApplicationTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "home/{user}") {
                    composable("home/{user}") { entry ->
                        entry.arguments?.getString("user")?.let { user ->
                            Home(
                                user = User(user, ""),
                                location = userLocation,
                                onBackToSignIn = {
                                    navController.navigate("signUp")
                                })

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
                                navController.navigate("RecoveryAccount")
                            },
                            onEntryAccount = { user ->
                                navController.navigate("home/${user.username} ")
                            }
                        )
                    }
                    composable("signUp") {
                        SignUp(
                            onBackToSignIn = {
                                navController.navigate("SignIn")
                            },
                            onRegisterUser = { user ->
                               postRegisterUser(user, navController, lifecycleScope)
                            }

                        )
                    }
                    composable("RegisterAddress") {
                        RegisterAddressUser(onRegisterAddress = { /*TODO*/ }) {

                        }
                    }
                    composable("RecoveryAccount") {
                        RecoveryAccount(
                            onBackToSignIn = {
                                navController.navigate("SignIn")
                            }
                        )
                    }
                }

            }

        }
    }
}
