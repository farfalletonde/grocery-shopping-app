package com.example.getirclone

import android.app.Application
import android.content.Context

class Application: Application() {
    override fun onCreate() {
        super.onCreate()
        com.example.getirclone.Application.appContext = applicationContext
    }

    companion object {

        lateinit  var appContext: Context

    }
}