package com.example.getirclone.ui.itemDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.getirclone.model.Product
import com.example.getirclone.repository.BasketRepository
import kotlinx.coroutines.launch

class ItemDetailViewModel
constructor(private val basketRepository: BasketRepository): ViewModel() {
    fun addToBasket(product: Product) {
        viewModelScope.launch {
            basketRepository.upsert(product)
        }
    }

    fun deleteProductFromBasket(product: Product) {
        viewModelScope.launch {
            basketRepository.deleteProduct(product)
        }
    }
}