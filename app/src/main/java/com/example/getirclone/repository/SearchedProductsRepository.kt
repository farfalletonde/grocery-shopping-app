package com.example.getirclone.repository

import com.example.getirclone.api.RetrofitInstance

class SearchedProductsRepository {
    suspend fun getProducts() = RetrofitInstance.api.searchGroceryProducts()
}