package com.example.guestink.android.services

import com.example.guestink.android.models.CEPResponse
import com.example.guestink.android.models.GeocodingResponse
import com.example.guestink.android.utils.RetrofitCEP
import com.example.guestink.android.utils.RetrofitClient
import kotlinx.serialization.json.Json
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GetCEPService {
    @GET("{cep}/json")
    fun getCEP(
        @Path("cep") cep: String,
    ): Call<CEPResponse>
}

fun fetchCEP(
    cep: String,
    onSuccess: (CEPResponse) -> Unit,
    onFailure: (String) -> Unit
) {
    val call = RetrofitCEP.retrofitService.getCEP(cep)
    call.enqueue(object : Callback<CEPResponse> {
        override fun onResponse(
            call: Call<CEPResponse>,
            response: Response<CEPResponse>
        ) {
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    onSuccess(body)
                } else {
                    onFailure("Nenhuma localização encontrada")
                }
            } else {
                onFailure("Erro na resposta: ${response.code()}")
            }
        }

        override fun onFailure(call: Call<CEPResponse>, t: Throwable) {
            TODO("Not yet implemented")
        }
    })
}