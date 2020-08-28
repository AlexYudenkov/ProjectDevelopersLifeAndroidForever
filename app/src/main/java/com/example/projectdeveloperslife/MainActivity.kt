package com.example.projectdeveloperslife

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var next: ImageView
    private lateinit var prev: ImageView
    //private val progressDialog: ImageView =


    private val presenter = presenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    private fun unit(){
        next = findViewById(R.id.imageView4)
        prev = findViewById(R.id.imageView3)
        val context = getApplicationContext();



        //обработка нажатия на кнопку next
        next.setOnClickListener(View.OnClickListener {
            presenter.comtex = applicationContext
            presenter.ad() })

        //обработка на жатия на кнопку prev
        next.setOnClickListener(View.OnClickListener { presenter.ad() })
    }
}