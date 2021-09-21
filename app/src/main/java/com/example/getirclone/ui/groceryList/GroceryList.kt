package com.example.getirclone.ui.groceryList

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.getirclone.adapter.GroceryListAdapter
import com.example.getirclone.databinding.FragmentGroceryListBinding

class GroceryList : Fragment() {

    private var _binding: FragmentGroceryListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentGroceryListBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        val viewModel = GroceryListViewModel()
        val recyclerView = binding.productsRecyclerView
        recyclerView.setHasFixedSize(true)
        viewModel.searchResults.observe(viewLifecycleOwner, Observer {
            recyclerView.adapter = GroceryListAdapter(it)
            Log.e("MainA", it[0].title)
        })

        return binding.root
    }

}

