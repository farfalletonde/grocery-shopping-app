package com.example.getirclone.ui.orderConfirmation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.getirclone.model.Product
import com.example.getirclone.repository.BasketRepository
import kotlinx.coroutines.launch

class OrderConfirmationViewModel: ViewModel() {

    fun deleteProductFromBasket(product: Product) {
        viewModelScope.launch {
            BasketRepository.deleteProduct(product)
        }
    }

    fun getBasketProducts() = BasketRepository.getAllBasketItems()
}