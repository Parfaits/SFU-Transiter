package com.example.sfutransiter.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sfutransiter.repository.Repository

class TransitViewModel(private val repository: Repository) : ViewModel() {
    private var busesByRoute = MutableLiveData<Array<Bus>>()
    private var stopsNear = MutableLiveData<Array<BusStop>>()

    fun getBusesByRoute(routeId: String): LiveData<Array<Bus>> {
        busesByRoute = repository.getBusesByRoute(routeId)
        return busesByRoute
    }

    fun getStopsNear(
        lat: Double,
        long: Double,
        radius: Int? = null,
        routeId: String? = null
    ): LiveData<Array<BusStop>> {
        stopsNear = repository.getStopsNear(lat, long, radius, routeId)
        return stopsNear
    }
}