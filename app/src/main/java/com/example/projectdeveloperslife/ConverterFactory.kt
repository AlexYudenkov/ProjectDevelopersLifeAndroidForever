package com.example.projectdeveloperslife

import okhttp3.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ConverterFactory {
    private var retrofit: Retrofit = Retrofit.Builder().baseUrl("https://developerslife.ru/random?json=true")
        .addConverterFactory(GsonConverterFactory.create())
        .build();

   var messagesApi = retrofit.create(MessagesApi::class.java)

    var messages1: retrofit2.Call<Post> = messagesApi.messages()



}