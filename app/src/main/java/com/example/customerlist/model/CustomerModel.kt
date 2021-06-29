package com.example.customerlist.model

import com.google.gson.annotations.SerializedName


data class CustomerModel (

    @SerializedName("currency")
    val first_name:  String,
    @SerializedName("price")
    val last_name:  String,
/*
    val email : String,

    val tel : String,

    val content : String,

    val created_date : String
  */
    ) {

}