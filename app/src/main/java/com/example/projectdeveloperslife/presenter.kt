package com.example.projectdeveloperslife

import android.content.Context
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide


class presenter :Observer {

    private val model  = model()

    var list = Listoch()

    var r = list.mutableList
    var t = r.size
    lateinit var comtex : Context
    lateinit var image : ImageView
    lateinit var text: TextView
    var url1:String = ""

    public fun ad(){
        Log.i("Proverka","wwwww")
        model.performWork(){ result ->
            if (result != null) {
                addpost(result)
            }
        }
        url1 = model.url.toString()
    }
    fun addpost(Post:Post) {
        val result = Post.gifURL
        val result1 = result.replace(
            "http", // old value
            "https", // new value
            true // ignore case
        )
        Post.gifURL=result1//add https
        r.addAll(listOf(Post))
        t++
        showImage()
    }

    override fun OnEvent(o: String?) {
        TODO("Not yet implemented")
    }

    fun prevent(){
        if(t!=0){
            t--
        }
    showImage()
    }
    fun showImage(){
        Glide.with(comtex).asGif()
            .load(r[t-1].gifURL)
            .into(image)
        text.text = r[t-1].description
    }


}