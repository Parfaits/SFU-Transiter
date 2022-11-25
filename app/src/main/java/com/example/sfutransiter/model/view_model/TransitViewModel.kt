package com.example.sfutransiter.model.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sfutransiter.model.Bus
import com.example.sfutransiter.model.BusStop
import com.example.sfutransiter.model.StopEstimate
import com.example.sfutransiter.repository.TLinkRepo
import retrofit2.Response

class TransitViewModel(private val repository: TLinkRepo) : ViewModel() {
    private var busesByRoute = MutableLiveData<Response<Array<Bus>>>()
    private var stopsNear = MutableLiveData<Response<Array<BusStop>>>()
    private var stopEstimates = MutableLiveData<Response<Array<StopEstimate>>>()

    fun getBusesByRoute(routeId: String): LiveData<Response<Array<Bus>>> {
        busesByRoute = repository.getBusesByRoute(routeId)
        return busesByRoute
    }

    fun getStopsNear(
        lat: Double,
        long: Double,
        radius: Int? = null,
        routeId: String? = null
    ): LiveData<Response<Array<BusStop>>> {
        stopsNear = repository.getStopsNear(lat, long, radius, routeId)
        return stopsNear
    }

    fun getStopEstimates(
        stopNo: Int,
        count: Int? = null,
        timeframe: Int? = null,
        routeNo: String? = null
    ): LiveData<Response<Array<StopEstimate>>> {
        stopEstimates = repository.getStopEstimates(stopNo, count, timeframe, routeNo)
        return stopEstimates
    }
}