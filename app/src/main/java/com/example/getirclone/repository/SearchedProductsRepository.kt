package com.example.getirclone.repository

import com.example.getirclone.api.GroceryApi

class SearchedProductsRepository(private val api: GroceryApi) {
    suspend fun getProducts() = api.searchGroceryProducts()
}