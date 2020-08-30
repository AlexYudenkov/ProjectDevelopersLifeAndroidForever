package com.example.projectdeveloperslife

import retrofit2.Call
import retrofit2.http.GET

interface TopApi {
    @GET("top/2?json=true")
    fun messagesTop(): Call<ListPost?>



}