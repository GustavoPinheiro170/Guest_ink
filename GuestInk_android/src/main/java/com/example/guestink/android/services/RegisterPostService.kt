package com.example.guestink.android.services

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LifecycleCoroutineScope

import androidx.navigation.NavHostController
import com.example.guestink.android.network.orionServices
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@SuppressLint("CoroutineCreationDuringComposition")
fun postRegisterUser(user: User, navController: NavHostController, lifecycleScope: LifecycleCoroutineScope) {

    lifecycleScope.launch {
        orionServices().registerUser(user).enqueue(object : Callback<UserResponse> {
            override fun onResponse(
                call: Call<UserResponse>,
                response: Response<UserResponse>
            ) {
                if(response.isSuccessful) {
                    Log.d("Response", response.toString())
                    navController.navigate("RegisterAddress")
                }
            }

            override fun onFailure(
                call: Call<UserResponse>,
                t: Throwable
            ) {
                Log.d("Response", t.toString())
            }

        })
    }
}