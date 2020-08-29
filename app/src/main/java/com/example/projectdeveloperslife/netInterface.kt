package com.example.projectdeveloperslife

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface netInterface {
    @GET("/random?json=true")
    //open fun getPostWithID(@Path("id") id: Int): Call<Post?>?
    fun messages(): Call<Post?>?

}