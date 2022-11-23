package com.example.sfutransiter.model

import java.util.*

data class Buses(
    val buses: ArrayList<String>,
    val bus: String,
    val vehicleNo: Int,
    val tripId: Int,
    val routeNo: Int,
    val direction: String,
    val pattern: String,
    val latitude: Double,
    val longitude: Double,
    val recordedTime: Calendar,
    val routeMap: String,
    val href: String,
)
