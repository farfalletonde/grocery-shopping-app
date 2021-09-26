package com.example.getirclone.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.getirclone.R
import kotlinx.android.synthetic.main.activity_shopping.*

class ShoppingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        bottomNavigationView.setupWithNavController(supportFragmentManager
            .findFragmentById(R.id.appNavHostFragment)!!
            .findNavController()
        )
    }
}