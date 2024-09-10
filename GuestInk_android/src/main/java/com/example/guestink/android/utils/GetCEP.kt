package com.example.guestink.android.utils


import com.example.guestink.android.services.GetCEPService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitCEP {
    private const val BASE_URL = "https://viacep.com.br/ws/"

    val retrofitService: GetCEPService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GetCEPService::class.java)
    }



}