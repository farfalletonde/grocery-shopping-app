package com.example.getirclone.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.getirclone.R


class ShoppingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)


        /*
        lifecycleScope.launchWhenCreated {
            val response = try {
                RetrofitInstance.api.searchGroceryProducts()
            }
            catch (e: IOException) {
                Log.e(TAG, "IOException")
                return@launchWhenCreated
            }
            catch (e: HttpException) {
                Log.e(TAG, "HttpException")
                return@launchWhenCreated
            }

            if (response.isSuccessful && response.body() != null) {
                Log.d(TAG, response.body()!!.products[0].title)
            }
            else {
                Log.e(TAG, "olmadıııı")
            }
        }
         */
    }
}