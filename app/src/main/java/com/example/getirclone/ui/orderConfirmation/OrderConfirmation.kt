package com.example.getirclone.ui.orderConfirmation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.getirclone.databinding.FragmentOrderConfirmationBinding

class OrderConfirmation : Fragment() {

    private var _binding: FragmentOrderConfirmationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentOrderConfirmationBinding.inflate(inflater, container, false)
        val viewModel = ViewModelProvider(this, OrderConfirmationViewModelProviderFactory()).get(OrderConfirmationViewModel::class.java)
        binding.confirmOrderBtn.setOnClickListener {
            viewModel.getBasketProducts().observe(viewLifecycleOwner, Observer {
                for(product in it)
                    viewModel.deleteProductFromBasket(product)
            })
            requireView().findNavController().navigate(OrderConfirmationDirections.actionOrderConfirmationToGroceryList())

        }
        return binding.root
    }
}