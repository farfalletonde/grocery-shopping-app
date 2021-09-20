package com.example.getirclone.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.getirclone.R
import com.example.getirclone.model.ProductDetail

class GroceryListAdapter(
        private val context: Context,
        private val dataset: List<ProductDetail>) : RecyclerView.Adapter<GroceryListAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(view: View): RecyclerView.ViewHolder(view){
        val itemName = view.findViewById<TextView>(R.id.listItemName)
        val itemPrice = view.findViewById<TextView>(R.id.listItemPrice)
        val itemImage = view.findViewById<ImageView>(R.id.listItemImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.grocery_list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.itemName.text = "item.title"
        holder.itemPrice.text = item.price.toString()
    }

    override fun getItemCount() = dataset.size
}