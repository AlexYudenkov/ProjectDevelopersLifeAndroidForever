package com.example.projectdeveloperslife

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide;

class presenter {

    lateinit var comtex : Context
    lateinit var image : ImageView
    private val model = model()

    //говорим моделу чтобы шел загружать гифку
    public fun ad(){
            model.randomgif()
            var url = model.getString()
            Glide.with(comtex).asGif()
            .load("https://static.devli.ru/public/images/gifs/201310/da8dc5d8-cea5-47ec-af50-c5c2c078cfc4.gif")
            .into(image)
            //.placeholder(R.id.imageView)
    }
}