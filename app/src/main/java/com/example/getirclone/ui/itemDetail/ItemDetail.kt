package com.example.getirclone.ui.itemDetail

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.example.getirclone.R
import com.example.getirclone.database.BasketDatabase
import com.example.getirclone.databinding.FragmentItemDetailBinding
import com.example.getirclone.repository.BasketRepository

class ItemDetail : Fragment() {

    private var _binding: FragmentItemDetailBinding? = null
    private val binding get() = _binding!!

    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentItemDetailBinding.inflate(inflater, container, false)

        val args = ItemDetailArgs.fromBundle(requireArguments())
        binding.productName.text = args.product.title
        Glide.with(this).load(args.product.image).into(binding.productImage)

        val viewModel = ViewModelProvider(this, ItemDetailViewModelProviderFactory()).get(ItemDetailViewModel::class.java)
        binding.addToBasketBtn.setOnClickListener {
            viewModel.addToBasket(args.product)
        }
        binding.button.setOnClickListener {
            requireView().findNavController().navigate(ItemDetailDirections.actionItemDetailToBasket())
        }

        return binding.root
    }

}