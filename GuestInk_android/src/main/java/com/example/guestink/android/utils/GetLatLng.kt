package com.example.guestink.android.utils

import com.example.guestink.android.models.GeocodingResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback


fun fetchLatLng(
    address: String,
    apiKey: String,
    onSuccess: (Double, Double) -> Unit,
    onFailure: (String) -> Unit
) {
    val call = RetrofitClient.retrofitService.getLatLng(address, apiKey)
    call.enqueue(object : Callback<GeocodingResponse> {
         override fun onResponse(call: Call<GeocodingResponse>, response: Response<GeocodingResponse>) {
            if (response.isSuccessful) {
                val location = response.body()?.results?.firstOrNull()?.geometry?.location
                if (location != null) {
                    onSuccess(location.lat, location.lng)
                } else {
                    onFailure("Nenhuma localização encontrada")
                }
            } else {
                onFailure("Erro na resposta: ${response.code()}")
            }
        }

         override fun onFailure(call: Call<GeocodingResponse>, t: Throwable) {
            onFailure("Falha na solicitação: ${t.message}")
        }
    })
}