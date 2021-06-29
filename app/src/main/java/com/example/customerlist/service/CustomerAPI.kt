package com.example.customerlist.service

import com.example.customerlist.model.CustomerModel
import retrofit2.Call
import retrofit2.http.GET

interface CustomerAPI {

    //Get, POST, UPDATE, DELETE
    @GET("atilsamancioglu/K21-JSONDataSet/master/crypto.json")
    fun getData(): Call<List<CustomerModel>>
}