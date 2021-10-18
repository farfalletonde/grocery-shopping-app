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
                Modules.basketRepositoryModule,
                Modules.searchedProductsRepositoryModule,
                Modules.basketViewModelModule,
                Modules.groceryListViewModelModule,
                Modules.itemDetailViewModelModule,
                Modules.orderConfirmationViewModelModule)
        }
    }

    companion object {
        lateinit var appContext: Context
    }
}