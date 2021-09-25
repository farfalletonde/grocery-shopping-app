package com.example.getirclone.ui.groceryList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.getirclone.repository.SearchedProductsRepository

class GroceryListViewModelProviderFactory(
    val productsRepository: SearchedProductsRepository
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return GroceryListViewModel(productsRepository) as T
    }
}