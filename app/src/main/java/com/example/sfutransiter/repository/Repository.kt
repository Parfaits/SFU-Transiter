package com.example.sfutransiter.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.sfutransiter.backend.RetrofitInterface
import com.example.sfutransiter.model.Bus
import com.example.sfutransiter.model.BusStop
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit

/**
 * Class for communication between Translink API and our model
 * @see <a href="https://www.translink.ca/about-us/doing-business-with-translink/app-developer-resources/rtti">Real-time Transit Information (RTTI)</a>
 */
class Repository(retrofit: Retrofit) {
    private val api = retrofit.create(RetrofitInterface::class.java)

    /**
     * Get the buses by route
     * @param routeId the route (e.g. 145)
     */
    fun getBusesByRoute(routeId: String): MutableLiveData<Array<Bus>> {
        val busesLiveData = MutableLiveData<Array<Bus>>()
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

    /**
     * Get the stops near lat long coordinates
     * @param lat latitude
     * @param long longitude
     * @param radius the radius to search in meters (is defaulted to 500)
     * @param routeNo the route (e.g 144)
     * */
    fun getStopsNear(
        lat: Double,
        long: Double,
        radius: Int? = null,
        routeNo: String? = null
    ): MutableLiveData<Array<BusStop>> {
        val stopsLiveData = MutableLiveData<Array<BusStop>>()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = api.getStopsNear(lat, long, radius, routeNo)
                if (response.isSuccessful) {
                    stopsLiveData.postValue(response.body()!!)
                } else {
                    Log.e(Repository::class.java.simpleName, "getStopsNear: $response")
                }
            } catch (e: java.lang.Exception) {
                Log.e(Repository::class.java.simpleName, "getStopsNear: Failed to get data, $e")
            }
        }
        return stopsLiveData
    }
}