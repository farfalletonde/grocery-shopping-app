package com.example.getirclone.model.searchCallbackModel

data class SearchedProductCallback(
    val type: String,
    val products: List<Product>,
    val offset: Int,
    val number: Int,
    val totalProducts: Int,
    val processingTimeMs: Int,
    val expires: Long,
    val isStale: Boolean
)