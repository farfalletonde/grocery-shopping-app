package com.example.getirclone.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.getirclone.api.RetrofitInstance
import com.example.getirclone.model.Product
import kotlinx.coroutines.*
import java.io.IOException
import java.lang.Exception

class SearchedProductsRepository {
    private val _properties = MutableLiveData<List<Product>>()
    val properties: LiveData<List<Product>>
        get() = _properties


    fun getProducts(): LiveData<List<Product>> {
        GlobalScope.launch(Dispatchers.Main) {
            val response = try {
                RetrofitInstance.api.searchGroceryProducts()
            }
            catch (e: IOException) {
                Log.e("Repository", "no internet")
                return@launch
            }
            catch (e: Exception) {
                Log.e("Repository", "exception")
                return@launch
            }
            if(response.isSuccessful && response.body() != null) {
                _properties.value = response.body()!!
            }
        }
        return properties
    }
}