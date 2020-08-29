package com.example.projectdeveloperslife

interface Observer {
    fun update(notification: Any?, source: Any?)
}