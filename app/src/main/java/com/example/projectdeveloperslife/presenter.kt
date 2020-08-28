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
            Glide.with(comtex)
            .load("http://static.devli.ru/public/images/gifs/201502/8c89d2e3-7095-4d93-a0f9-1de4739c76f1.gif")
                .into(image)
            //.placeholder(R.id.imageView)
    }
}