package com.example.sfutransiter.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.sfutransiter.backend.RetrofitInterface
import com.example.sfutransiter.model.Buses
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class Repository(retrofit: Retrofit) {
    private val api = retrofit.create(RetrofitInterface::class.java)

    fun getBusesByRoute(routeId: String): MutableLiveData<Array<Buses>> {
        val busesLiveData = MutableLiveData<Array<Buses>>()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = api.getBusesByRoute(routeId)
                if (response.isSuccessful) {
                    busesLiveData.postValue(response.body()!!)
                } else {
                    Log.e(Repository::class.java.simpleName, "getBuses: $response")
                }
            } catch (e: java.lang.Exception) {
                Log.e(Repository::class.java.simpleName, "getBuses: Failed to get data, $e")
            }
        }
        return busesLiveData
    }
}