package com.example.projectdeveloperslife

import android.content.Context
import android.content.Intent
import android.provider.Settings.Global.getString
import android.provider.Settings.System.getString
import android.util.Log
import android.widget.ImageView
import androidx.core.content.res.TypedArrayUtils.getString
import com.bumptech.glide.Glide;

class presenter {

    lateinit var comtex : Context
    lateinit var image : ImageView
    var url1:String = ""

    public fun ad(mutList: MutList) {

        var modeli: model = model()
        var i:Int = 0
        while(i < 10) {
            modeli.randomgif(mutList)
            i++
        }

        }
    }





