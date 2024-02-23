package com.example.bebettaassignment.utils

import android.content.Context
import com.example.bebettaassignment.models.Match
import com.example.bebettaassignment.models.MatchPreview
import com.example.bebettaassignment.models.Tickr
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class JsonUtils {
    companion object{
        fun readJsonFromAssets(context: Context, fileName: String): String {
            return context.assets.open(fileName).bufferedReader().use { it.readText() }
        }

        fun parseJsonToModelMatch(jsonString: String): List<Match> {
            val gson = Gson()
            return gson.fromJson(jsonString, object : TypeToken<List<Match>>() {}.type)
        }

        fun parseJsonToModelTickr(jsonString: String): List<Tickr> {
            val gson = Gson()
            return gson.fromJson(jsonString, object : TypeToken<List<Tickr>>() {}.type)
        }

        fun parseJsonToModelMatchPreview(jsonString: String): List<MatchPreview> {
            val gson = Gson()
            return gson.fromJson(jsonString, object : TypeToken<List<MatchPreview>>() {}.type)
        }
    }
}