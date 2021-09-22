package com.example.getirclone.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.getirclone.model.Product

@Dao
interface BasketDatabaseDao {

    @Query("SELECT * FROM basket_product")
    fun getAllBasketItems() : LiveData<List<Product>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(product: Product): Long

    @Delete
    suspend fun deleteProduct(product: Product)
}