package com.example.projectdeveloperslife

import android.app.Activity
import android.app.PendingIntent.getActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide;
import java.security.AccessController.getContext


class MainActivity : AppCompatActivity() {

    private lateinit var next: ImageView
    private lateinit var prev: ImageView
    private lateinit var Image: ImageView
    private lateinit var Image1: ImageView
    //private val progressDialog: ImageView =


    private val presenter = presenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //

        setContentView(R.layout.activity_main)
        Image = findViewById(R.id.imageView)
        unit()
        /*Glide.with(applicationContext)
            .load("https://static.devli.ru/public/images/previews/201308/d0906011-2d12-489a-af69-d9446402c2ed.jpg")
            .into(Image)
*/

    }
    private fun unit(){
        next = findViewById(R.id.imageView4)
        prev = findViewById(R.id.imageView3)
        Image =findViewById(R.id.okno)
        val context = applicationContext


        //обработка нажатия на кнопку next
        next.setOnClickListener(View.OnClickListener {
            presenter.comtex = context
            presenter.image = Image
            presenter.ad()
            })

            //обработка на жатия на кнопку prev
            //next.setOnClickListener(View.OnClickListener { presenter.ad() }

    }
}