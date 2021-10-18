package com.example.getirclone

import android.app.Application
import com.example.getirclone.di.Modules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@Application)
            modules(Modules.apiModule,
                Modules.roomModule,
                Modules.repositoriesModule,
                Modules.viewModelsModule)
        }
    }

}