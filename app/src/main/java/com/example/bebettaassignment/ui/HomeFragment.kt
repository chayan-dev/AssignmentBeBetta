package com.example.bebettaassignment.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bebettaassignment.R
import com.example.bebettaassignment.utils.JsonUtils.Companion.parseJsonToModelMatch
import com.example.bebettaassignment.utils.JsonUtils.Companion.parseJsonToModelMatchPreview
import com.example.bebettaassignment.utils.JsonUtils.Companion.parseJsonToModelTickr
import com.example.bebettaassignment.utils.JsonUtils.Companion.readJsonFromAssets
import com.example.bebettaassignment.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var liveMatchesAdapter: LiveMatchesAdapter
    private lateinit var mostHappeningAdapter: MostHappeningAdapter
    private lateinit var matchPreviewAdapter: MatchPreviewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        initAdapter()
        addClickListener()
        return binding.root
    }

    private fun addClickListener() {

        binding.tv1x.setOnClickListener {
            betClickAction(1)
        }
        binding.tv2x.setOnClickListener {
            betClickAction(2)
        }
        binding.tv5x.setOnClickListener {
            betClickAction(3)
        }
        binding.tv10x.setOnClickListener {
            betClickAction(4)
        }

        binding.layoutRewards.setOnClickListener {
            val bottomSheet = BottomSheetDialog()
            bottomSheet.show(parentFragmentManager, "ModalBottomSheet")
        }
    }

    private fun betClickAction(position: Int) {
        when (position) {
            1 -> {
                binding.marker1x.visibility = View.VISIBLE
                binding.marker2x.visibility = View.INVISIBLE
                binding.marker5x.visibility = View.INVISIBLE
                binding.marker10x.visibility = View.INVISIBLE
                binding.tv1x.setBackgroundResource(R.drawable.bets_item_bg)
                binding.tv2x.setBackgroundResource(android.R.color.transparent)
                binding.tv5x.setBackgroundResource(android.R.color.transparent)
                binding.tv10x.setBackgroundResource(android.R.color.transparent)
            }
            2 -> {
                binding.marker2x.visibility = View.VISIBLE
                binding.marker1x.visibility = View.INVISIBLE
                binding.marker10x.visibility = View.INVISIBLE
                binding.marker5x.visibility = View.INVISIBLE
                binding.tv2x.setBackgroundResource(R.drawable.bets_item_bg)
                binding.tv1x.setBackgroundResource(android.R.color.transparent)
                binding.tv10x.setBackgroundResource(android.R.color.transparent)
                binding.tv5x.setBackgroundResource(android.R.color.transparent)
            }
            3 -> {
                binding.marker5x.visibility = View.VISIBLE
                binding.marker10x.visibility = View.INVISIBLE
                binding.marker1x.visibility = View.INVISIBLE
                binding.marker2x.visibility = View.INVISIBLE
                binding.tv5x.setBackgroundResource(R.drawable.bets_item_bg)
                binding.tv1x.setBackgroundResource(android.R.color.transparent)
                binding.tv10x.setBackgroundResource(android.R.color.transparent)
                binding.tv2x.setBackgroundResource(android.R.color.transparent)
            }
            4 -> {
                binding.marker10x.visibility = View.VISIBLE
                binding.marker1x.visibility = View.INVISIBLE
                binding.marker2x.visibility = View.INVISIBLE
                binding.marker5x.visibility = View.INVISIBLE
                binding.tv10x.setBackgroundResource(R.drawable.bets_item_bg)
                binding.tv1x.setBackgroundResource(android.R.color.transparent)
                binding.tv5x.setBackgroundResource(android.R.color.transparent)
                binding.tv2x.setBackgroundResource(android.R.color.transparent)

            }
        }
    }

    private fun initAdapter() {

        val jsonStringMatch = readJsonFromAssets(requireContext(), "MatchData.json")
        val matchList = parseJsonToModelMatch(jsonStringMatch)
        liveMatchesAdapter = LiveMatchesAdapter(matchList)
        binding.rvScoreCard.adapter = liveMatchesAdapter

        val jsonStringTickr = readJsonFromAssets(requireContext(), "TickrData.json")
        val mostHappeningTickr = parseJsonToModelTickr(jsonStringTickr)
        mostHappeningAdapter = MostHappeningAdapter(mostHappeningTickr)
        binding.rvMostHappening.adapter = mostHappeningAdapter

        val jsonStringPreview = readJsonFromAssets(requireContext(), "PreviewData.json")
        val previewList = parseJsonToModelMatchPreview(jsonStringPreview)
        matchPreviewAdapter = MatchPreviewAdapter(previewList)
        binding.rvMatchPreview.adapter = matchPreviewAdapter
    }

}