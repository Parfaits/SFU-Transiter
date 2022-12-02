package com.example.sfutransiter.model

import com.google.gson.annotations.SerializedName

class User {
    /**
     * @param userName Required only for creating new user
     */
    data class RequestBody(
        @SerializedName("userName")
        val userName: String? = null,
        @SerializedName("password")
        val password: String,
        @SerializedName("email")
        val email: String,
        @SerializedName("firstName")
        val firstName: String,
        @SerializedName("lastName")
        val lastName: String,
    )

    data class DeleteRequestBody(
        @SerializedName("password")
        val password: String
    )

    data class Response(
        @SerializedName("userRn")
        val userRn: String,
        @SerializedName("userName")
        val userName: String,
        @SerializedName("email")
        val email: String,
        @SerializedName("firstName")
        val firstName: String,
        @SerializedName("lastName")
        val lastName: String,
        @SerializedName("status")
        val status: String,
    )
}
