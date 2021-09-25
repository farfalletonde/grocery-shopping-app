package com.example.getirclone.ui.groceryList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.getirclone.model.Product
import com.example.getirclone.repository.SearchedProductsRepository
import kotlinx.coroutines.launch

const val TAG = "MainActivity"

class GroceryListViewModel(val productsRepository: SearchedProductsRepository) : ViewModel() {

    val productsList = MutableLiveData<List<Product>>()
    init {
        getProducts()
    }
    private fun getProducts() = viewModelScope.launch {
        productsList.value = productsRepository.getProducts().body()
    }

}