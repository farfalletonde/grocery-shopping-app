package com.example.getirclone.ui.itemDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.getirclone.repository.BasketRepository

class ItemDetailViewModelProviderFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ItemDetailViewModel() as T
    }
}