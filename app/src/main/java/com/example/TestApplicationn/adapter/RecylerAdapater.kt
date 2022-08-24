package com.example.TestApplicationn.adapter

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.TestApplicationn.databinding.RecylerItemsBinding
import com.example.TestApplicationn.pojo.Restaurant

class RecylerAdapater :
    ListAdapter<Restaurant, RecylerAdapater.MyViewHolder>(RestaurantComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            RecylerItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    class MyViewHolder(private val binding: RecylerItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(restaurant: Restaurant) {
            binding.apply {
                Glide.with(itemView)
                    .load(restaurant.logo)
                    .into(imageViewLogo)

                textViewName.text = restaurant.name
                textViewType.text = restaurant.type
                textViewAddress.text = restaurant.address
            }
        }
    }

    class RestaurantComparator : DiffUtil.ItemCallback<Restaurant>() {
        override fun areItemsTheSame(oldItem: Restaurant, newItem: Restaurant) =
            oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: Restaurant, newItem: Restaurant) =
            oldItem == newItem
    }

}