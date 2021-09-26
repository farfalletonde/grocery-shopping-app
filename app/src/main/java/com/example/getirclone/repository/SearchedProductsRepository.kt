package com.example.getirclone.repository

import com.example.getirclone.api.RetrofitInstance

object SearchedProductsRepository {
    suspend fun getProducts() = RetrofitInstance.api.searchGroceryProducts()
}