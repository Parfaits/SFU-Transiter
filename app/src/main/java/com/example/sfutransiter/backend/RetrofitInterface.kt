package com.example.sfutransiter.backend

import com.example.sfutransiter.BuildConfig
import com.example.sfutransiter.model.Buses
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface RetrofitInterface {
    @Headers(
        "Accept: application/json",
        "Content-type: application/JSON"
    )
    @GET("buses?apikey=${BuildConfig.TRANSLINK_API_KEY}")
    suspend fun getBusesByRoute(@Query("routeNo") routeNo: String): Response<Array<Buses>>
}