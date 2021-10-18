package com.example.getirclone.repository

import com.example.getirclone.database.BasketDatabase
import com.example.getirclone.model.Product

class BasketRepository(private val database: BasketDatabase) {

    fun getAllBasketItems() = database.getProductDao().getAllBasketItems()

    suspend fun upsert(product: Product) = database.getProductDao().upsert(product)

    suspend fun deleteProduct(product: Product) = database.getProductDao().deleteProduct(product)

}