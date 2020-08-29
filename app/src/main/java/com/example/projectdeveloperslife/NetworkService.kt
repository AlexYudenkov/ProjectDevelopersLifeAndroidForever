package com.example.projectdeveloperslife

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkService {
    private var mInstance: NetworkService? = null
    private val BASE_URL:String = "https://developerslife.ru"
    private lateinit var mRetrofit: Retrofit


    private fun NetworkService():NetworkService {
        mRetrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        mRetrofit.create(netInterface::class.java)

        return NetworkService()
    }


    fun getInstance(): NetworkService? {
        if (mInstance == null) {
            Log.i("Proverka","one")
            mInstance = NetworkService()
        }
        return mInstance
    }
    fun getJSONApi(): netInterface? {//messages api
        Log.i("Proverka","getJsApi")
        return mRetrofit.create<netInterface>(netInterface::class.java)
    }


}
