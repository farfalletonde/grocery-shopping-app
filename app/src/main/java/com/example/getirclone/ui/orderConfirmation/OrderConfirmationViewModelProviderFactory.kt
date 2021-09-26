package com.example.getirclone.ui.orderConfirmation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class OrderConfirmationViewModelProviderFactory: ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return OrderConfirmationViewModel() as T
    }
}