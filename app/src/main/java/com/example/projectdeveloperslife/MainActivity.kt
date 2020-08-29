package com.example.projectdeveloperslife

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ActionMenuView
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.bumptech.glide.Glide;


class MainActivity : AppCompatActivity()  {

    private lateinit var next: ImageView
    private lateinit var prev: ImageView
    private lateinit var Image: ImageView

    //private lateinit var manager:android.app.FragmentManager
    //private lateinit var transaction:android.app.FragmentTransaction
    //private var screen: Screen = Screen()

    private val presenter = presenter()

    var i:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       var mutList: MutList = MutList()
        setContentView(R.layout.activity_main)


        next = findViewById(R.id.next)
        prev = findViewById(R.id.prev)
        Image =findViewById(R.id.screen)
        val context = applicationContext

        unit(mutList)



        //обработка нажатия на кнопку next

        next.setOnClickListener(View.OnClickListener {
            i++
                Log.i("Proverka",""+i)

                if( i + 1 == mutList.mutableList.size ) {
                    presenter.comtex = context
                    presenter.image = Image
                    presenter.ad(mutList)

                }

            if (i + 1 == mutList.mutableList.size) {
                val handler2 = android.os.Handler()
                handler2.postDelayed({
                    var fulurl: String = "https"
                    var url: String = mutList.mutableList[i].gifURL.toString()
                    var backurl: String = url.drop(4)
                    fulurl += backurl
                    Glide.with(context).asGif()
                        .load(fulurl.toString())
                        .into(Image)

                }, 1500) }
            else{
                var fulurl: String = "https"
                var url: String = mutList.mutableList[i].gifURL.toString()
                var backurl: String = url.drop(4)
                fulurl += backurl
                Glide.with(context).asGif()
                    .load(fulurl.toString())
                    .into(Image)
            }

            })


        prev.setOnClickListener(View.OnClickListener {
            Log.i("Proverka", ""+i)
            if(i == 0) { }
            if(i > 0) {
                    i--
                    var fulurl: String = "https"
                    var url: String = mutList.mutableList[i].gifURL.toString()
                    var backurl: String = url.drop(4)
                    fulurl += backurl
                    Glide.with(context).asGif()
                        .load(fulurl.toString())
                        .into(Image)

                       }
            })


    }

    fun unit(mutList: MutList){
        presenter.comtex = applicationContext
        presenter.image = Image
        presenter.ad(mutList)

        val handler2 = android.os.Handler()
        handler2.postDelayed({
            var fulurl: String = "https"
            var url: String = mutList.mutableList[0].gifURL.toString()
            var backurl: String = url.drop(4)
            fulurl += backurl
            Glide.with(applicationContext).asGif()
                .load(fulurl.toString())
                .into(Image)

        }, 1500)
    }
}