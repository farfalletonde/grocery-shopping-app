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
import com.google.android.material.snackbar.Snackbar

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
            if(basketItems.isNotEmpty()) {
                recyclerView.visibility = View.VISIBLE
                recyclerView.adapter = BasketListAdapter(requireContext(), basketItems, this)
                binding.emptyBasketTv.text = ""
                binding.confirmBasketBtn.visibility = View.VISIBLE
            }
            else {
                recyclerView.visibility = View.GONE
                binding.confirmBasketBtn.visibility = View.GONE
                binding.emptyBasketTv.text = "Basket is empty."
            }
        })

        binding.confirmBasketBtn.setOnClickListener {
            requireView().findNavController().navigate(BasketDirections.actionBasketToOrderConfirmation())
        }

        return binding.root
    }

    override fun onItemClick(item: Product) {
        (viewModel as BasketViewModel).deleteProductFromBasket(item)
        Snackbar.make(binding.basketLayout, "${item.title} removed from basket.", Snackbar.LENGTH_LONG)
            .setAction("Undo", View.OnClickListener {
                (viewModel as BasketViewModel).addToBasket(item)
            }).show()
    }

}