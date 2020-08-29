package com.example.projectdeveloperslife

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




data class Post (
    val description: String,
    val id: Long,
    val gifURL: String,
    val votes: Int,
    val author: String,
    val date: String,
    val gifSize: Int,
    val previewURL: String,
    val videoURL: String,
    val videoPath: String,
    val videoSize: Int,
    val type: String,
    val width: String,
    val height: String,
    val commentsCount: Int,
    val fileSize:String,
    val canVote: Boolean)
/*
    private var id:Int = 0

    private var description: String? = null

    private var title: String? = null

    private var author: String? = null

    private var gifUrl: String? = null

    fun getId(): Int {
        return id
    }

    fun setId(id: Int) {
        this.id = id
    }

    fun getDesc(): String {
        return description.toString()

    }

    fun setDesc(description: String) {
        this.description = description
    }

    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String?) {
        this.title = title
    }

    fun getUrl(): String? {
        return gifUrl
    }

    fun setUrl(gifUrl: String?) {
        this.gifUrl = gifUrl
    }*/
//}