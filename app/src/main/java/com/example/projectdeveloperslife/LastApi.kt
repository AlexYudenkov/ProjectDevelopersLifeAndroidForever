package com.example.projectdeveloperslife

import retrofit2.Call
import retrofit2.http.GET

interface LastApi {
    @GET("latest/0?json=true")
    fun messagesLast(): Call<ListPost?>
}