package com.example.guestink.android.utils

import com.example.guestink.android.services.OrionApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object OrionObject {

    private const val BASE_URL = "http://192.168.0.107/8443/api/v1/orion/auth/"

    val apiService: OrionApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(OrionApiService::class.java)
    }
}