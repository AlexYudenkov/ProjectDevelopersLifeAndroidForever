package com.example.projectdeveloperslife

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide


class MainActivity : AppCompatActivity()  {

    private lateinit var next: ImageView
    private lateinit var prev: ImageView
    private lateinit var Image: ImageView
    private lateinit var Last: TextView
    private lateinit var Top: TextView
    private lateinit var Hot: TextView
    private lateinit var LastBlue: TextView
    private lateinit var TopBlue: TextView
    private lateinit var HotBlue: TextView
    private lateinit var Description: TextView
    private lateinit var Notification: TextView

    //private lateinit var manager:android.app.FragmentManager
    //private lateinit var transaction:android.app.FragmentTransaction
    //private var screen: Screen = Screen()

    private val presenter = presenter()

    var iLast:Int = 0
    var iTop:Int = 0
    var iHot:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var mutListLast: MutList = MutList()
        var mutListTop: MutList = MutList()
        var mutListHot: MutList = MutList()

        var sectionNow: Int = 1
        setContentView(R.layout.activity_main)

        Description = findViewById(R.id.description)
        Last = findViewById(R.id.last)
        Top = findViewById(R.id.top)
        Hot = findViewById(R.id.hot)
        LastBlue = findViewById(R.id.lastblue)
        TopBlue = findViewById(R.id.topblue)
        HotBlue = findViewById(R.id.hotblue)
        Notification = findViewById(R.id.notification)
        LastBlue.setVisibility(View.VISIBLE);
        TopBlue.setVisibility(View.INVISIBLE);
        HotBlue.setVisibility(View.INVISIBLE);
        Notification.setVisibility(View.INVISIBLE);

        next = findViewById(R.id.next)
        prev = findViewById(R.id.prev)
        Image =findViewById(R.id.screen)
        val context = applicationContext

        Image.setBackgroundResource(R.drawable.animation_load)
        val animation = Image.getBackground() as AnimationDrawable
        animation.start()


        Start(mutListLast, mutListTop, mutListHot, sectionNow)



       Last.setOnClickListener(View.OnClickListener {
           LastBlue.setVisibility(View.VISIBLE);
           TopBlue.setVisibility(View.INVISIBLE);
           HotBlue.setVisibility(View.INVISIBLE);

           if(mutListLast.mutableList.size == 0){Notification.setVisibility(View.VISIBLE); Glide.with(applicationContext).asGif()
               .load("https://cdn1.savepice.ru/uploads/2020/8/30/11a11f76205a16263b650b8fcd4700c8-full.png")
               .into(Image)}
           else {
               Notification.setVisibility(View.INVISIBLE);
               val handler2 = android.os.Handler()
               handler2.postDelayed({
                   var fulurl: String = "https"
                   var url: String = mutListLast.mutableList[iLast].gifURL.toString()
                   var backurl: String = url.drop(4)
                   fulurl += backurl
                   Glide.with(applicationContext).asGif()
                       .load(fulurl.toString())
                       .into(Image)
                   Description.setText(mutListLast.mutableList[iLast].description.toString())

               }, 1500)
           }
           sectionNow = 1

       })

        Top.setOnClickListener(View.OnClickListener {
            LastBlue.setVisibility(View.INVISIBLE);
            TopBlue.setVisibility(View.VISIBLE);
            HotBlue.setVisibility(View.INVISIBLE);
            if(mutListTop.mutableList.size == 0){Notification.setVisibility(View.VISIBLE);Glide.with(applicationContext).asGif()
                .load("https://cdn1.savepice.ru/uploads/2020/8/30/11a11f76205a16263b650b8fcd4700c8-full.png")
                .into(Image) }
            else {
                Notification.setVisibility(View.INVISIBLE);
                val handler2 = android.os.Handler()
                handler2.postDelayed({
                    var fulurl: String = "https"
                    var url: String = mutListTop.mutableList[iTop].gifURL.toString()
                    var backurl: String = url.drop(4)
                    fulurl += backurl
                    Glide.with(applicationContext).asGif()
                        .load(fulurl.toString())
                        .into(Image)

                }, 1500)
                Description.setText(mutListTop.mutableList[iTop].description.toString())
            }
            sectionNow = 2
        })

        Hot.setOnClickListener(View.OnClickListener {
            HotBlue.setVisibility(View.VISIBLE);
            LastBlue.setVisibility(View.INVISIBLE);
            TopBlue.setVisibility(View.INVISIBLE);
            if(mutListHot.mutableList.size == 0){Notification.setVisibility(View.VISIBLE);Glide.with(applicationContext).asGif()
                .load("https://cdn1.savepice.ru/uploads/2020/8/30/11a11f76205a16263b650b8fcd4700c8-full.png")
                .into(Image)}
            else {
                Notification.setVisibility(View.INVISIBLE);
                val handler2 = android.os.Handler()
                handler2.postDelayed({
                    var fulurl: String = "https"
                    var url: String = mutListHot.mutableList[iHot].gifURL.toString()
                    var backurl: String = url.drop(4)
                    fulurl += backurl
                    Glide.with(applicationContext).asGif()
                        .load(fulurl.toString())
                        .into(Image)

                }, 1500)
                Description.setText(mutListHot.mutableList[iHot].description.toString())
            }
            sectionNow = 3
        })


        next.setOnClickListener(View.OnClickListener {
                if(sectionNow == 1) {
                    if (mutListLast.mutableList.size == 0) {
                    }
                    else {
                        iLast++
                        Log.i("Proverka", "" + iLast)

                        if (iLast + 1 == mutListLast.mutableList.size) {
                            presenter.addLast(mutListLast)

                            val handler2 = android.os.Handler()
                            handler2.postDelayed({
                                var fulurl: String = "https"
                                var url: String = mutListLast.mutableList[iLast].gifURL.toString()
                                var backurl: String = url.drop(4)
                                fulurl += backurl
                                Glide.with(context).asGif()
                                    .load(fulurl.toString())
                                    .into(Image)

                            }, 3000)
                            Description.setText(mutListLast.mutableList[iLast].description.toString())
                        } else {
                            var fulurl: String = "https"
                            var url: String = mutListLast.mutableList[iLast].gifURL.toString()
                            var backurl: String = url.drop(4)
                            fulurl += backurl
                            Glide.with(context).asGif()
                                .load(fulurl.toString())
                                .into(Image)
                            Description.setText(mutListLast.mutableList[iLast].description.toString())
                        }
                    }
                }
                if(sectionNow == 2){
                        if(mutListTop.mutableList.size == 0){}
                        else {
                            iTop++
                            //Log.i("Proverka",""+i)

                            if (iTop + 1 == mutListTop.mutableList.size) {
                                presenter.addTop(mutListTop)

                            }

                            if (iTop + 1 == mutListTop.mutableList.size) {
                                val handler2 = android.os.Handler()
                                handler2.postDelayed({
                                    var fulurl: String = "https"
                                    var url: String = mutListTop.mutableList[iTop].gifURL.toString()
                                    var backurl: String = url.drop(4)
                                    fulurl += backurl
                                    Glide.with(context).asGif()
                                        .load(fulurl.toString())
                                        .into(Image)

                                }, 3000)
                                Description.setText(mutListTop.mutableList[iTop].description.toString())
                            } else {
                                var fulurl: String = "https"
                                var url: String = mutListTop.mutableList[iTop].gifURL.toString()
                                var backurl: String = url.drop(4)
                                fulurl += backurl
                                Glide.with(context).asGif()
                                    .load(fulurl.toString())
                                    .into(Image)
                                Description.setText(mutListTop.mutableList[iTop].description.toString())
                            }
                        }

                }
                if(sectionNow == 3){
                        if(mutListHot.mutableList.size == 0){}
                        else {
                            iHot++
                            //Log.i("Proverka",""+i)

                            if (iHot + 1 == mutListHot.mutableList.size) {
                                presenter.addHot(mutListHot)

                            }

                            if (iHot + 1 == mutListHot.mutableList.size) {
                                val handler2 = android.os.Handler()
                                handler2.postDelayed({
                                    var fulurl: String = "https"
                                    var url: String = mutListHot.mutableList[iHot].gifURL.toString()
                                    var backurl: String = url.drop(4)
                                    fulurl += backurl
                                    Glide.with(context).asGif()
                                        .load(fulurl.toString())
                                        .into(Image)

                                }, 3000)
                                Description.setText(mutListHot.mutableList[iHot].description.toString())
                            } else {
                                var fulurl: String = "https"
                                var url: String = mutListHot.mutableList[iHot].gifURL.toString()
                                var backurl: String = url.drop(4)
                                fulurl += backurl
                                Glide.with(context).asGif()
                                    .load(fulurl.toString())
                                    .into(Image)
                                Description.setText(mutListHot.mutableList[iHot].description.toString())
                            }
                        }

                }

            })

        prev.setOnClickListener(View.OnClickListener {
                if(sectionNow == 1) {
                    if (mutListLast.mutableList.size == 0) {
                    } else {
                        if (iLast == 0) {
                        }
                        if (iLast > 0) {
                            iLast--
                            var fulurl: String = "https"
                            var url: String = mutListLast.mutableList[iLast].gifURL.toString()
                            var backurl: String = url.drop(4)
                            fulurl += backurl
                            Glide.with(context).asGif()
                                .load(fulurl.toString())
                                .into(Image)
                            Description.setText(mutListLast.mutableList[iLast].description.toString())

                        }
                    }
                }
                if(sectionNow == 2){
                    if(mutListTop.mutableList.size == 0){}
                    else {
                        //Log.i("Proverka", ""+i)
                        if (iTop == 0) {
                        }
                        if (iTop > 0) {
                            iTop--
                            var fulurl: String = "https"
                            var url: String = mutListTop.mutableList[iTop].gifURL.toString()
                            var backurl: String = url.drop(4)
                            fulurl += backurl
                            Glide.with(context).asGif()
                                .load(fulurl.toString())
                                .into(Image)
                            Description.setText(mutListTop.mutableList[iTop].description.toString())

                        }
                    }
                }
                if(sectionNow == 3){
                    if(mutListHot.mutableList.size == 0){}
                    else {
                        //Log.i("Proverka", ""+i)
                        if (iHot == 0) {
                        }
                        if (iHot > 0) {
                            iHot--
                            var fulurl: String = "https"
                            var url: String = mutListHot.mutableList[iHot].gifURL.toString()
                            var backurl: String = url.drop(4)
                            fulurl += backurl
                            Glide.with(context).asGif()
                                .load(fulurl.toString())
                                .into(Image)
                            Description.setText(mutListHot.mutableList[iHot].description.toString())

                        }
                    }
                }
            })




    }

    fun Start(mutListLast: MutList, mutListTop: MutList, mutListHot: MutList, sectionNow: Int){
        Log.i("Proverka", "Start")
        presenter.addLast(mutListLast)
        presenter.addTop(mutListTop)
        presenter.addHot(mutListHot)


            val handler2 = android.os.Handler()
            handler2.postDelayed({
                if(mutListLast.mutableList.size == 0){Notification.setVisibility(View.VISIBLE);}
                else {
                    var fulurl: String = "https"
                    var url: String = mutListLast.mutableList[0].gifURL.toString()
                    var backurl: String = url.drop(4)
                    fulurl += backurl
                    Glide.with(applicationContext).asGif()
                        .load(fulurl.toString())
                        .into(Image)
                    Description.setText(mutListLast.mutableList[iLast].description.toString())
                }
            }, 3000)




    }
}