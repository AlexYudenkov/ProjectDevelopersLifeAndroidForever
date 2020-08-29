package com.example.projectdeveloperslife

import retrofit2.Call
import retrofit2.http.GET

interface MessagesApi {
    @GET("random?json=true")
    fun messages(): Call<Post>

}