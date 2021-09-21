package com.example.getirclone.ui.groceryList

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.example.getirclone.R
import com.example.getirclone.adapter.GroceryListAdapter
import com.example.getirclone.databinding.FragmentGroceryListBinding

class GroceryList : Fragment(), GroceryListAdapter.OnItemClickListener {

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
            recyclerView.adapter = GroceryListAdapter(requireContext(), it, this)
            Log.e("MainA", it[0].title)
        })

        return binding.root
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(requireContext(), "item ${position.toString()} clicked", Toast.LENGTH_LONG).show()
    }

}

