package com.example.guestink.android.services

import kotlinx.serialization.Serializable
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface OrionApiService {
    @Headers("Authorization: Basic b3Jpb246YmFzaWNhdXRo")
    @POST("register")
     fun registerUser(@Body user: User): Call<UserResponse>
}

data class User(var password: String, var name: String, var email: String, var typeProfile: String)

data class UserResponse(var id: Long) {
    fun toRegisterResponse() = UserResponse(
        id = id
    )
}