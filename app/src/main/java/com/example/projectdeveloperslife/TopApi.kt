package com.example.projectdeveloperslife

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface TopApi {
    @GET("top/{id}?json=true")
    open fun getData(
        @Path("id") count: Int
    ): Call<ListPost?>



}