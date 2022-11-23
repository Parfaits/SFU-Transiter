package com.example.sfutransiter.repository

import android.util.Log
import com.example.sfutransiter.backend.RetrofitInterface
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class Repository(private val retrofit: Retrofit) {
    private val api = retrofit.create(RetrofitInterface::class.java)

    fun getBuses(busId: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            Log.d("swag", "getBuses: huh")
            try {
                val response = api.getBusesById()
                Log.d("swag", "getBuses: $response")
                if (response.isSuccessful) {
                    Log.d("swag", "getBuses: hell yea")
                }
            } catch (e: java.lang.Exception) {
                Log.e(Repository::class.java.simpleName, "getBuses: Failed to get data, $e")
            }
        }
    }
}