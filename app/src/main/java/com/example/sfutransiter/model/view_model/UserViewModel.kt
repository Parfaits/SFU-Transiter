package com.example.sfutransiter.model.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sfutransiter.model.User
import com.example.sfutransiter.repository.AWSRepo
import retrofit2.Response

class UserViewModel(private val repository: AWSRepo) : ViewModel() {
    private var user = MutableLiveData<Response<User.Response>>()

    fun createUser(
        body: User.RequestBody,
    ): LiveData<Response<User.Response>> {
        user = repository.createUser(body)
        return user
    }

    fun getUser(
        userName: String,
        userRn: String
    ): LiveData<Response<User.Response>> {
        user = repository.getUser(userName, userRn)
        return user
    }

    fun updateUser(
        userName: String,
        userRn: String,
        body: User.RequestBody
    ): LiveData<Response<User.Response>> {
        user = repository.updateUser(userName, userRn, body)
        return user
    }
}