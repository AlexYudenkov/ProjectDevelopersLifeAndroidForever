package com.example.projectdeveloperslife

import android.content.Context
import android.os.AsyncTask
import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class model {

    var url: String = ""

    private var information:String = ""


    fun Lastgif(mutList: MutList){

        var mRetrofit = Retrofit.Builder()
            .baseUrl("https://developerslife.ru")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        var a= mRetrofit.create(LastApi::class.java)
        var r = a.messagesLast()
        Log.i("Proverka","rand")
        //прасит строку
        //Network
        if (r != null) {
            r.enqueue(object: Callback<Post?> {

                override fun onResponse(call: Call<Post?>, response: Response<Post?>) {
                    Log.i("Proverka","yes")
                    Log.i("Proverka", response.code().toString())
                    if (response.code() == 200) {
                        val post = response.body()!!
                        mutList.mutableList.add(post)
                        Log.i("Proverka",url)

                    }
                }

                override fun onFailure(call: Call<Post?>, t: Throwable) {
                    Log.i("Proverka","No")
                    Log.e("error1", t.toString());
            }
            })
        }


    }

    fun Topgif(mutList: MutList){

        var mRetrofit = Retrofit.Builder()
            .baseUrl("https://developerslife.ru")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        var a= mRetrofit.create(TopApi::class.java)
        var r = a.messagesTop()
        Log.i("Proverka","rand")
        //прасит строку
        //Network
        if (r != null) {
            r.enqueue(object: Callback<Post?> {

                override fun onResponse(call: Call<Post?>, response: Response<Post?>) {
                    Log.i("Proverka","yes")
                    Log.i("Proverka", response.code().toString())
                    if (response.code() == 200) {
                        val post = response.body()!!
                        mutList.mutableList.add(post)
                        Log.i("Proverka",url)

                    }
                }

                override fun onFailure(call: Call<Post?>, t: Throwable) {
                    Log.i("Proverka","No")
                    Log.e("error1", t.toString());
                }
            })
        }


    }

    fun Hotgif(mutList: MutList){

        var mRetrofit = Retrofit.Builder()
            .baseUrl("https://developerslife.ru")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        var a= mRetrofit.create(HotApi::class.java)
        var r = a.messagesHot()
        Log.i("Proverka","rand")
        //прасит строку
        //Network
        if (r != null) {
            r.enqueue(object: Callback<Post?> {

                override fun onResponse(call: Call<Post?>, response: Response<Post?>) {
                    Log.i("Proverka","yes")
                    Log.i("Proverka", response.code().toString())
                    if (response.code() == 200) {
                        val post = response.body()!!
                        mutList.mutableList.add(post)
                        Log.i("Proverka",url)

                    }
                }

                override fun onFailure(call: Call<Post?>, t: Throwable) {
                    Log.i("Proverka","No")
                    Log.e("error1", t.toString());
                }
            })
        }


    }


    fun getString():String{
        return url.toString()
    }

    fun getInformation():String{
        return information
    }





}


