package com.example.bugdemo.data.remote

import com.example.bugdemo.data.model.FeedItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ApiService {
    private val gson = Gson()

    suspend fun getFeedItems(): List<FeedItem> {
        val response = ApiClient().get("/api/feed")

        val type = object : TypeToken<List<FeedItem>>() {}.type
        return gson.fromJson(response, type) ?: emptyList()
    }
}
