package com.example.sfutransiter.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sfutransiter.repository.Repository

class TransitViewModel(private val repository: Repository) : ViewModel() {
    private var busesByRoute = MutableLiveData<Array<Buses>>()

    fun getBusesByRoute(routeId: String): LiveData<Array<Buses>> {
        busesByRoute = repository.getBusesByRoute(routeId)
        return busesByRoute
    }
}