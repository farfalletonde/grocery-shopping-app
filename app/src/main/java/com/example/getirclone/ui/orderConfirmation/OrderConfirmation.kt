package com.example.getirclone.ui.orderConfirmation

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.getirclone.R
import com.example.getirclone.databinding.FragmentOrderConfirmationBinding
import com.google.android.material.snackbar.Snackbar

class OrderConfirmation : Fragment() {

    private var _binding: FragmentOrderConfirmationBinding? = null
    private val binding get() = _binding!!

    private val CHANNEL_ID = "channelID"
    private val CHANNEL_NAME = "channelName"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        _binding = FragmentOrderConfirmationBinding.inflate(inflater, container, false)
        val viewModel = ViewModelProvider(this, OrderConfirmationViewModelProviderFactory()).get(OrderConfirmationViewModel::class.java)

        //creates notification and notification manager
        val notification = NotificationCompat.Builder(requireContext(), CHANNEL_ID)
            .setContentTitle("Shopping App")
            .setContentText("Your order is on the way!")
            .setSmallIcon(R.drawable.ic_baseline_shopping_basket_24)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .build()
        val notificationManager = NotificationManagerCompat.from(requireContext())


        binding.confirmOrderBtn.setOnClickListener {
            viewModel.getBasketProducts().observe(viewLifecycleOwner, Observer {
                for(product in it)
                    viewModel.deleteProductFromBasket(product)
            })

            //create the notification channel if necessary and notify
            createNotificationChannel()
            notificationManager.notify(0, notification)

            Snackbar.make(binding.orderConfirmationLayout, "Order successfully confirmed.", Snackbar.LENGTH_LONG).setAnchorView(R.id.bottomNavigationView).show()
            requireView().findNavController().navigate(OrderConfirmationDirections.actionOrderConfirmationToGroceryList())

        }
        return binding.root
    }

    private fun createNotificationChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME,
            NotificationManager.IMPORTANCE_DEFAULT)

            val notificationManager: NotificationManager =
                requireActivity().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            notificationManager.createNotificationChannel(channel)
        }
    }
}