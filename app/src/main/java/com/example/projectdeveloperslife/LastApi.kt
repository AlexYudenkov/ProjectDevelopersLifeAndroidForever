package com.example.projectdeveloperslife

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface LastApi {

    @GET("latest/{id}?json=true")
    open fun getData(
        @Path("id") count: Int
    ): Call<ListPost?>


}