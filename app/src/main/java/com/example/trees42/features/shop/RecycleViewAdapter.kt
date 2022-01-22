package com.example.trees42.features.shop

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.trees42.R
import com.example.trees42.databinding.ItemShopBinding
import com.example.trees42.model.Tree
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class RecycleViewAdapter @Inject constructor(@ApplicationContext val context: Context): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var data: MutableList<Tree> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ShopViewHolder(ItemShopBinding.bind(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_shop,
                parent,
                false
            )
        ))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as ShopViewHolder).binding

        binding.itemName.text = data[position].name
        binding.itemPrice.text = data[position].price
        binding.itemImage.setImageDrawable(
            context.getDrawable(
                context.resources.getIdentifier(
                    data[position].imageId,
                    "drawable",
                    context.packageName)
            )
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setData(newData: MutableList<Tree>){
        data = newData
        Log.d("tagg", data.size.toString())
        notifyDataSetChanged()
    }

    private class ShopViewHolder(val binding: ItemShopBinding):RecyclerView.ViewHolder(binding.root)
}