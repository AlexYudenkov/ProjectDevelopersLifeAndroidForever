package com.example.projectdeveloperslife

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class model {

    var listener: (()->Unit)? = null
    private var mListener //listener field
            : Observer? = null

    //setting the listener
    fun setCustomEventListener(eventListener: Observer?) {
        mListener = eventListener
    }

    var url: String? = null
    var netWork = NetworkService()

    private var information:String = ""



    fun performWork( myCallback: (result: Post?) -> Unit) {

        var mRetrofit = Retrofit.Builder()
            .baseUrl("https://developerslife.ru")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        var a= mRetrofit.create(netInterface::class.java)
        var r = a.messages()
        Log.i("Proverka","rand")
        //прасит строку
        //Network
        if (r != null) {
            r.enqueue(object: Callback<Post?> {
                //Log.i("Proverka","yes")
                override fun onResponse(call: Call<Post?>, response: Response<Post?>) {
                    Log.i("Proverka","yes")
                    Log.i("Proverka", response.code().toString())
                    if (response.code() == 200) {
                        val post = response.body()!!
                        url = post.gifURL
                        //Presenter.url1 = url as String
                        Log.i("Proverka",url)
                        mListener?.OnEvent(url)
                        myCallback.invoke(post)
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


