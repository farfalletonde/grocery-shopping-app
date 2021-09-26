package com.example.getirclone.ui.groceryList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class GroceryListViewModelProviderFactory: ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return GroceryListViewModel() as T
    }
}