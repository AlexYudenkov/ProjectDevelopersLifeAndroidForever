package com.example.projectdeveloperslife.HotApi

import com.example.projectdeveloperslife.ListPost
import com.example.projectdeveloperslife.MutList
import retrofit2.Call
import retrofit2.http.GET

interface HotApi {

    @GET("hot/0?json=true")
    fun messagesHot(): Call<ListPost?>

}