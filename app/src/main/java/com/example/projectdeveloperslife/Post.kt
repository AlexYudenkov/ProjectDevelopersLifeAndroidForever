package com.example.projectdeveloperslife

data class Post(
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
    val canVote: Boolean
)