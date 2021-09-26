package com.example.getirclone.ui.itemDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.getirclone.R
import com.example.getirclone.databinding.FragmentItemDetailBinding
import com.google.android.material.snackbar.Snackbar

class ItemDetail : Fragment() {

    private var _binding: FragmentItemDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentItemDetailBinding.inflate(inflater, container, false)

        val args = ItemDetailArgs.fromBundle(requireArguments())

        binding.apply {
            productName.text = args.product.title
            productDescription.text = args.product.description
            Glide.with(this@ItemDetail).load(args.product.image).into(productImage)
        }

        val viewModel = ViewModelProvider(this, ItemDetailViewModelProviderFactory()).get(ItemDetailViewModel::class.java)

        binding.addToBasketBtn.setOnClickListener {
            viewModel.addToBasket(args.product)

            Snackbar.make(binding.itemDetailLayout, "${args.product.title} added to basket.", Snackbar.LENGTH_LONG)
                .setAction("Undo", View.OnClickListener {
                    viewModel.deleteProductFromBasket(args.product)
                }).setAnchorView(R.id.bottomNavigationView).show()
        }


        return binding.root
    }

}