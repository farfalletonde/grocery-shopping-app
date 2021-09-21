package com.example.getirclone.api

import com.example.getirclone.model.Products
import retrofit2.Response
import retrofit2.http.GET

interface GroceryApi {

    @GET("/products")
    suspend fun searchGroceryProducts() : Response<Products>

}