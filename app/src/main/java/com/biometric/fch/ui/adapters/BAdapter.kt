package com.biometric.fch.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.biometric.fch.R
import com.biometric.fch.data.network.entities.bebidas.Drink
import com.biometric.fch.databinding.FrutaItemsBinding


class BAdapter :
    ListAdapter<Drink, BAdapter.RymVH>(DiffUtilResultCallBack) {
    class RymVH(view: View) : RecyclerView.ViewHolder(view) {
        private var binding: FrutaItemsBinding = FrutaItemsBinding.bind(view)

        fun render(item: Drink) {
            binding.nobelImg.load("https://openclipart.org/image/800px/167281")
            binding.nobelYear.text = item.idDrink
            binding.nobelCategory.text = item.strGlass
            binding.nobelName.text = item.strCategory
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RymVH {
        val inflater = LayoutInflater.from(parent.context)
        return RymVH(inflater.inflate(R.layout.fruta_items, parent, false))
    }

    override fun onBindViewHolder(holder: RymVH, position: Int) {
        holder.render(getItem(position))
    }

    object DiffUtilResultCallBack : DiffUtil.ItemCallback<Drink>() {

        override fun areItemsTheSame(oldItem: Drink, newItem: Drink): Boolean {
            return (oldItem.idDrink == newItem.idDrink)
        }

        override fun areContentsTheSame(oldItem: Drink, newItem: Drink): Boolean {
            return (oldItem == newItem)
        }
    }
}