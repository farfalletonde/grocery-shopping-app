package com.example.getirclone.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
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
        val itemName: TextView = view.findViewById(R.id.listItemName)
        val itemPrice: TextView = view.findViewById(R.id.listItemPrice)
        val itemImage: ImageView = view.findViewById(R.id.listItemImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.grocery_list_item, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        val itemPrice = "%.2f".format(item.price)
        val formattedItemPrice = "$itemPrice ${context.resources.getString(R.string.currency)}"
        holder.itemName.text = item.title
        holder.itemPrice.text = formattedItemPrice
        Glide.with(context).load(item.image).into(holder.itemImage)
    }

    override fun getItemCount() = dataset.size

    interface OnItemClickListener {
        fun onItemClick(position: Int, item: Product)
    }
}