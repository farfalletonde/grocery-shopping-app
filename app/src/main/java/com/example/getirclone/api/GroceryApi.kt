package com.example.getirclone.api

import com.example.getirclone.model.productDetailCallbackModel.ProductDetailCallback
import com.example.getirclone.model.searchCallbackModel.SearchedProductCallback
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GroceryApi {

    @GET("/food/products/search")
    suspend fun searchGroceryProducts(@Query("apiKey") apiKey: String = "80ac379be91a45d5ae26068b8516e891",
                              @Query("query") query: String = "a",
                              @Query("number") number: Int = 100) : Response<SearchedProductCallback>

    @GET("/food/products/{id}")
    suspend fun getProductInformation(@Path("id") id: Int,
                              @Query("apiKey") apiKey:String = "80ac379be91a45d5ae26068b8516e891"): Response<ProductDetailCallback>
}