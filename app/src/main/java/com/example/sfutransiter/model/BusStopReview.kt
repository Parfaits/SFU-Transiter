package com.example.sfutransiter.model

import com.google.gson.annotations.SerializedName

class BusStopReview() {
    data class Request(
        @SerializedName("bus")
        val routeNo: String,
        @SerializedName("comment")
        val comment: String? = null,
        @SerializedName("safety")
        val safety: String,
        @SerializedName("crowd")
        val crowd: Int,
        @SerializedName("authorRn")
        val authorRn: String? = null
    )

    data class Response(
        @SerializedName("stopReviewRn")
        val stopReviewRn: String,
        @SerializedName("busStop")
        val stopNo: String,
        @SerializedName("bus")
        val routeNo: String,
        @SerializedName("comment")
        val comment: String,
        @SerializedName("safety")
        val safety: String,
        @SerializedName("crowd")
        val crowd: Int,
        @SerializedName("author")
        val author: User
    )
}
