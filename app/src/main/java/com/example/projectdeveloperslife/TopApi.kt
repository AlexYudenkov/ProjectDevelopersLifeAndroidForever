package com.example.projectdeveloperslife

import retrofit2.Call
import retrofit2.http.GET

interface TopApi {
    @GET("random?json=true ")
    fun messagesTop(): Call<Post>



}