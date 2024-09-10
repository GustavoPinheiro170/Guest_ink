package com.example.guestink.android.network

import com.example.guestink.android.services.OrionApiService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val BASE_URL = "http://192.168.0.107:8443/api/v1/orion/auth/"

fun client() = OkHttpClient.Builder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .build()


fun gson(): Gson = GsonBuilder().create()


fun retrofit(): Retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .client(client())
    .addConverterFactory(GsonConverterFactory.create(gson())).build()


fun orionServices() = retrofit().create(OrionApiService::class.java);
