package com.example.getirclone.repository

import com.example.getirclone.Application
import com.example.getirclone.database.BasketDatabase
import com.example.getirclone.model.Product

object BasketRepository {

    private val database = BasketDatabase(Application.appContext)

    fun getAllBasketItems() = database.getProductDao().getAllBasketItems()

    suspend fun upsert(product: Product) = database.getProductDao().upsert(product)

    suspend fun deleteProduct(product: Product) = database.getProductDao().deleteProduct(product)

}