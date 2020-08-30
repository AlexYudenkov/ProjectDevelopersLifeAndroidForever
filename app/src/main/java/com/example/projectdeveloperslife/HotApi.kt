package com.example.projectdeveloperslife

import retrofit2.Call
import retrofit2.http.GET

interface HotApi {
    @GET("random?json=true")
    fun messagesHot(): Call<Post>
}