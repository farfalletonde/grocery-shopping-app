package com.example.getirclone.ui.basket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.getirclone.adapter.BasketListAdapter
import com.example.getirclone.databinding.FragmentBasketBinding
import com.example.getirclone.model.Product
import com.example.getirclone.ui.groceryList.GroceryListDirections

class Basket : Fragment(), BasketListAdapter.OnItemClickListener {


    private var _binding: FragmentBasketBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentBasketBinding.inflate(inflater, container, false)

        val recyclerView = binding.basketRecyclerView
        recyclerView.setHasFixedSize(true)


        viewModel = ViewModelProvider(this, BasketViewModelProviderFactory()).get(BasketViewModel::class.java)
        (viewModel as BasketViewModel).getBasketProducts().observe(viewLifecycleOwner, Observer { basketItems ->
            if(basketItems != null)
                recyclerView.adapter = BasketListAdapter(requireContext(), basketItems, this)
        })

        return binding.root
    }

    override fun onItemClick(item: Product) {
        (viewModel as BasketViewModel).deleteProductFromBasket(item)
    }

}