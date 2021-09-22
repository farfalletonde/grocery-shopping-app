package com.example.getirclone.ui.groceryList

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.getirclone.repository.SearchedProductsRepository

const val TAG = "MainActivity"

class GroceryListViewModel : ViewModel() {

    val searchRepository = SearchedProductsRepository()
    val productsList = searchRepository.getProducts()

}