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
    val basketRepositoryModule = module {
        single {
            BasketRepository
        }
    }
    val searchedProductsRepositoryModule = module {
        single {
            SearchedProductsRepository
        }
    }
    val basketViewModelModule = module {
        viewModel {
            BasketViewModel(get())
        }
    }
    val groceryListViewModelModule = module {
        viewModel {
            GroceryListViewModel(get())
        }
    }
    val itemDetailViewModelModule = module {
        viewModel {
            ItemDetailViewModel(get())
        }
    }
    val orderConfirmationViewModelModule = module {
        viewModel {
            OrderConfirmationViewModel(get())
        }
    }
}