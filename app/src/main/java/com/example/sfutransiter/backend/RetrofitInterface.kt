package com.example.sfutransiter.backend

import com.example.sfutransiter.BuildConfig
import com.example.sfutransiter.model.Buses
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface RetrofitInterface {
    @Headers(
        "Accept: application/json",
        "Content-type: application/JSON"
    )
    @GET("buses/${6657}?apikey=${BuildConfig.TRANSLINK_API_KEY}")
    suspend fun getBusesById(): Response<Buses>
}