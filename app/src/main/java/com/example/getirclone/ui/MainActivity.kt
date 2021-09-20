package com.example.getirclone.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.getirclone.R
import com.example.getirclone.adapter.GroceryListAdapter
import com.example.getirclone.api.RetrofitInstance
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception

const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val recyclerView = findViewById<RecyclerView>(R.id.groceryList)

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