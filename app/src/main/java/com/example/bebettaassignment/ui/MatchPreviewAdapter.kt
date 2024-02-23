package com.example.bebettaassignment.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bebettaassignment.R
import com.example.bebettaassignment.databinding.ItemMatchPreviewBinding
import com.example.bebettaassignment.models.MatchPreview
import com.example.bebettaassignment.utils.loadImage

class MatchPreviewAdapter(
    val previewList: List<MatchPreview>
) : RecyclerView.Adapter<MatchPreviewAdapter.MatchPreviewViewHolder>(){

    private lateinit var binding: ItemMatchPreviewBinding

    inner class MatchPreviewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchPreviewViewHolder {
        return MatchPreviewViewHolder(
            parent.context.getSystemService(LayoutInflater::class.java).inflate(
                R.layout.item_match_preview,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MatchPreviewViewHolder, position: Int) {
        binding = ItemMatchPreviewBinding.bind(holder.itemView)
        val matchPreviewItem = previewList[position]
        binding.apply {
            tvTeam1.text = matchPreviewItem.team1
            tvTeam2.text = matchPreviewItem.team2
            tvDuration.text = matchPreviewItem.duration
            ivPreview.loadImage(matchPreviewItem.previewImage)
        }
    }

    override fun getItemCount(): Int {
        return previewList.size
    }
}
