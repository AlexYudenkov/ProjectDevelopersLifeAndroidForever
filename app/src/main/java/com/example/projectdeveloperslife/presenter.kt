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

    var url1:String = ""

    public fun addLast(mutList: MutList) {

        var modeli: model = model()
        var i:Int = 0
        while(i < 10) {
            modeli.Lastgif(mutList)
            i++
        }

        }

    public fun addTop(mutList: MutList) {

        var modeli: model = model()
        var i:Int = 0
        while(i < 10) {
            modeli.Topgif(mutList)
            i++
        }

    }

    public fun addHot(mutList: MutList) {

        var modeli: model = model()
        var i:Int = 0
        while(i < 10) {
            modeli.Hotgif(mutList)
            i++
        }

    }
    }





