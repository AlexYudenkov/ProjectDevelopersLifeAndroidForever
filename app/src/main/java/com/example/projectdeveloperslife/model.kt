package com.example.projectdeveloperslife

import android.util.Log
import com.example.projectdeveloperslife.HotApi.HotApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class model {

    fun Lastgif(mutList: MutList){

        var mRetrofit = Retrofit.Builder()
            .baseUrl("https://developerslife.ru")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        var a= mRetrofit.create(LastApi::class.java)
        var r = a.getData(mutList.quantityrequest)
        mutList.quantityrequest += 1

        if (r != null) {
            r.enqueue(object: Callback<ListPost?> {

                override fun onResponse(call: Call<ListPost?>, response: Response<ListPost?>) {

                    if (response.code() == 200) {
                        val post = response.body()!!
                        var i:Int =0
                        while(i < post.result.size){
                            mutList.mutableList.add(post.result[i])
                            i++
                        }

                    }
                }

                override fun onFailure(call: Call<ListPost?>, t: Throwable) {

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
        var r = a.getData(mutList.quantityrequest)
        mutList.quantityrequest += 1

        if (r != null) {
            r.enqueue(object: Callback<ListPost?> {

                override fun onResponse(call: Call<ListPost?>, response: Response<ListPost?>) {

                    if (response.code() == 200) {
                        val post = response.body()!!
                        var i:Int =0
                        while(i < post.result.size){
                            mutList.mutableList.add(post.result[i])
                            i++
                        }

                    }
                }

                override fun onFailure(call: Call<ListPost?>, t: Throwable) {

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
        var r = a.getData(mutList.quantityrequest)
        mutList.quantityrequest += 1

        if (r != null) {
            r.enqueue(object: Callback<ListPost?> {

                override fun onResponse(call: Call<ListPost?>, response: Response<ListPost?>) {
                    Log.i("Proverka","yes")
                    Log.i("Proverka", response.code().toString())
                    if (response.code() == 200) {
                        val post = response.body()!!
                        var i:Int =0
                        while(i < post.result.size){
                            mutList.mutableList.add(post.result[i])
                            i++
                        }



                    }
                }

                override fun onFailure(call: Call<ListPost?>, t: Throwable) {

                }
            })
        }


    }



}


