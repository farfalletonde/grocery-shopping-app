package com.example.getirclone

import android.app.Application
import android.content.Context
import com.example.getirclone.di.Modules
import org.koin.core.context.startKoin

class Application: Application() {
    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        startKoin {
            modules(Modules.apiModule,
                Modules.roomModule,
                Modules.repositoriesModule,
                Modules.viewModelsModule)
        }
    }

    companion object {
        lateinit var appContext: Context
    }
}