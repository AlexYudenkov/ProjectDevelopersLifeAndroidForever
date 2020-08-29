package com.example.projectdeveloperslife

import android.os.AsyncTask
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class model {


    var Presenter = presenter()
    private var url: String? = null
    var netWork = NetworkService()

    private var information:String = ""

    /*fun ret():Callback<Post> {
        @Override
        fun onFailure(call: Call<Post>?, t: Throwable?) {
            Log.v("retrofit", "call failed")
        }
        @Override
        fun on(call: Call<Post>?, t: Throwable?) {
            Log.v("retrofit", "call failed")
        }
        @Override
        fun onResponse(call: Call<Post>?, response: Response<Post>?) {
            val post = response?.body()
            if (post != null) {
                Log.d("Daady", post.getId().toString())
            }
        }
    }*/

    /*internal fun getCurrentData() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(netInterface::class.java)
        val call = service.messages()
        call?.enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                if (response.code() == 200) {
                    val weatherResponse = response.body()!!

                    val stringBuilder = "Country: " +
                            weatherResponse.sys!!.country +
                            "\n" +
                            "Temperature: " +
                            weatherResponse.main!!.temp +
                            "\n" +
                            "Temperature(Min): " +
                            weatherResponse.main!!.temp_min +
                            "\n" +
                            "Temperature(Max): " +
                            weatherResponse.main!!.temp_max +
                            "\n" +
                            "Humidity: " +
                            weatherResponse.main!!.humidity +
                            "\n" +
                            "Pressure: " +
                            weatherResponse.main!!.pressure

                    weatherData!!.text = stringBuilder
                }
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                weatherData!!.text = t.message
            }
        })
    }*/



    fun randomgif():Boolean {

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
                        Presenter.url1 = url as String
                        Log.i("Proverka",url)
                    }
                }

                override fun onFailure(call: Call<Post?>, t: Throwable) {
                    Log.i("Proverka","No")
                    Log.e("error1", t.toString());
            }
            })
        }

        return true
    }
            fun getString():String{
                return url.toString()
            }
            fun getInformation():String{
                return information
            }





}


