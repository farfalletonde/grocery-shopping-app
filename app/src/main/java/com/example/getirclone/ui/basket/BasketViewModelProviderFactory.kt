package com.example.getirclone.ui.basket

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class BasketViewModelProviderFactory: ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BasketViewModel() as T
    }
}