package com.example.bebettaassignment.ui

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bebettaassignment.R
import com.example.bebettaassignment.databinding.ItemScoreCardBinding
import com.example.bebettaassignment.models.Match

class LiveMatchesAdapter(
    val matchList: List<Match>
) : RecyclerView.Adapter<LiveMatchesAdapter.LiveMatchesViewHolder>(){

    private lateinit var binding: ItemScoreCardBinding

    inner class LiveMatchesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LiveMatchesViewHolder {
        return LiveMatchesViewHolder(
            parent.context.getSystemService(LayoutInflater::class.java).inflate(
                R.layout.item_score_card,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: LiveMatchesViewHolder, position: Int) {
        binding = ItemScoreCardBinding.bind(holder.itemView)
        binding.apply {
            val match = matchList[position]
            tvTeam1.text = match.team1
            tvTeam2.text = match.team2
            tvScore1.text = match.score1
            tvScore2.text = match.score2
            tvMinsPlayed.text = match.minsPlayed
            if(match.minsPlayed > "45 mins") tvMinsPlayed.setTextColor(ColorStateList.valueOf(Color.parseColor("#FFB800")))
            else tvMinsPlayed.setTextColor(ColorStateList.valueOf(Color.parseColor("#33C049")))
            if(position%2==0){
                binding.ivTeam1.setImageResource(R.drawable.ic_espanyol)
                binding.ivTeam2.setImageResource(R.drawable.at_madrid)
            }else {
                binding.ivTeam1.setImageResource(R.drawable.leeds)
                binding.ivTeam2.setImageResource(R.drawable.liverpool)
            }
        }
    }

    override fun getItemCount(): Int {
        return matchList.size
    }

}
