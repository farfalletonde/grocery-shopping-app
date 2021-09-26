package com.example.getirclone.ui.groceryList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.getirclone.adapter.GroceryListAdapter
import com.example.getirclone.databinding.FragmentGroceryListBinding
import com.example.getirclone.model.Product

class GroceryList : Fragment(), GroceryListAdapter.OnItemClickListener {

    private var _binding: FragmentGroceryListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentGroceryListBinding.inflate(inflater, container, false)

        val viewModel = ViewModelProvider(this, GroceryListViewModelProviderFactory()).get(GroceryListViewModel::class.java)
        val recyclerView = binding.productsRecyclerView

        recyclerView.setHasFixedSize(true)

        viewModel.productsList.observe(viewLifecycleOwner, Observer {
            recyclerView.adapter = GroceryListAdapter(requireContext(), it, this)
        })

        return binding.root
    }

    override fun onItemClick(position: Int, item: Product) {
        requireView().findNavController().navigate(GroceryListDirections.actionGroceryListToItemDetail(item))
    }

}

