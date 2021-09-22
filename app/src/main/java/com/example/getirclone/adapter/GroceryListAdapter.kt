package com.example.getirclone.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.getirclone.R
import com.example.getirclone.model.Product

class GroceryListAdapter(
    private val context: Context,
    private val dataset: List<Product>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<GroceryListAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(view: View): RecyclerView.ViewHolder(view){
        init {
            view.setOnClickListener {
                listener.onItemClick(adapterPosition, dataset[adapterPosition])
            }
        }
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
        holder.itemName.text = item.title
        holder.itemPrice.text = item.price.toString() + " ₺"
        Glide.with(context).load(item.image).into(holder.itemImage)
    }

    override fun getItemCount() = dataset.size

    interface OnItemClickListener {
        fun onItemClick(position: Int, item: Product)
    }
}