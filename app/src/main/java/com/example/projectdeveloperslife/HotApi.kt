package com.example.projectdeveloperslife.HotApi

import com.example.projectdeveloperslife.ListPost
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface HotApi {

    @GET("hot/{id}?json=true")
    open fun getData(
        @Path("id") count: Int
    ): Call<ListPost?>



}