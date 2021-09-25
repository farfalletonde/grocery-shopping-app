package com.example.getirclone.ui.basket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.getirclone.adapter.BasketListAdapter
import com.example.getirclone.database.BasketDatabase
import com.example.getirclone.databinding.FragmentBasketBinding
import com.example.getirclone.repository.BasketRepository

class Basket : Fragment() {


    private var _binding: FragmentBasketBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentBasketBinding.inflate(inflater, container, false)

        val recyclerView = binding.basketRecyclerView
        recyclerView.setHasFixedSize(true)


        val viewModel = ViewModelProvider(this, BasketViewModelProviderFactory()).get(BasketViewModel::class.java)
        viewModel.getBasketProducts().observe(viewLifecycleOwner, Observer {
            if(it != null) {
                recyclerView.adapter = BasketListAdapter(requireContext(), it)
            }
        })

        return binding.root
    }

}