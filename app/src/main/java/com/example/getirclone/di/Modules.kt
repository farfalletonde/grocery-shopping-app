package com.example.getirclone.di

import com.example.getirclone.api.RetrofitInstance
import com.example.getirclone.database.BasketDatabase
import com.example.getirclone.repository.BasketRepository
import com.example.getirclone.repository.SearchedProductsRepository
import com.example.getirclone.ui.basket.BasketViewModel
import com.example.getirclone.ui.groceryList.GroceryListViewModel
import com.example.getirclone.ui.itemDetail.ItemDetailViewModel
import com.example.getirclone.ui.orderConfirmation.OrderConfirmationViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object Modules {

    val apiModule = module {
        single {
            RetrofitInstance.api
        }
    }
    val roomModule = module {
        single {
            BasketDatabase.invoke(androidContext())
        }
    }
    val repositoriesModule = module {
        single {
            SearchedProductsRepository(get())
        }
        single {
            BasketRepository(get())
        }
    }
    val viewModelsModule = module {
        viewModel {
            BasketViewModel(get())
        }
        viewModel {
            ItemDetailViewModel(get())
        }
        viewModel {
            OrderConfirmationViewModel(get())
        }
        viewModel {
            GroceryListViewModel(get())
        }
    }
}
