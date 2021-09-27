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

class BasketListAdapter(
    private val context: Context,
    private val dataset: List<Product>,
    private val listener: OnItemClickListener): RecyclerView.Adapter<BasketListAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.findViewById<ImageView>(R.id.deleteIcon).setOnClickListener {
                listener.onItemClick(dataset[adapterPosition])
            }
        }

        val basketItemName: TextView = view.findViewById(R.id.basket_product_name)
        val basketItemPrice: TextView = view.findViewById(R.id.basket_product_price)
        val basketItemImage: ImageView = view.findViewById(R.id.basket_product_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.basket_list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        val itemPrice = "%.2f".format(item.price)
        val formattedItemPrice = "$itemPrice ${context.resources.getString(R.string.currency)}"
        holder.basketItemName.text = item.title
        holder.basketItemPrice.text = formattedItemPrice
        Glide.with(context).load(item.image).into(holder.basketItemImage)
    }

    override fun getItemCount() = dataset.size

    interface OnItemClickListener {
        fun onItemClick(item: Product)
    }

}