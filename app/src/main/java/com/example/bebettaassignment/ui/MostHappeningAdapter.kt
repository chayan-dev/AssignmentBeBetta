package com.example.bebettaassignment.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bebettaassignment.R
import com.example.bebettaassignment.databinding.ItemMostHappeningTickrBinding
import com.example.bebettaassignment.models.Tickr
import com.example.bebettaassignment.utils.loadImage

class MostHappeningAdapter(
    val itemList: List<Tickr>
) : RecyclerView.Adapter<MostHappeningAdapter.MostHappeningViewHolder>(){

    private lateinit var binding: ItemMostHappeningTickrBinding

    inner class MostHappeningViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MostHappeningViewHolder {
        return MostHappeningViewHolder(
            parent.context.getSystemService(LayoutInflater::class.java).inflate(
                R.layout.item_most_happening_tickr,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: MostHappeningViewHolder, position: Int) {
        binding = ItemMostHappeningTickrBinding.bind(holder.itemView)
        val item = itemList[position]
        binding.apply {
            tvName.text = item.name
            image.loadImage(item.image)
        }
    }
}
