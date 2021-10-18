package com.example.getirclone.ui.basket

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.getirclone.model.Product
import com.example.getirclone.repository.BasketRepository
import kotlinx.coroutines.launch

class BasketViewModel
constructor(val basketRepository: BasketRepository): ViewModel() {

    fun deleteProductFromBasket(product: Product) {
        viewModelScope.launch {
            basketRepository.deleteProduct(product)
        }
    }

    fun addToBasket(product: Product) {
        viewModelScope.launch {
            basketRepository.upsert(product)
        }
    }

    fun getBasketProducts() = basketRepository.getAllBasketItems()

}