package com.example.bugdemo.ui.home

import com.example.bugdemo.data.model.FeedItem
import com.example.bugdemo.data.remote.ApiService

class FeedRepository {
    private val apiService = ApiService()

    suspend fun fetchFeed(): List<FeedItem> {
        return apiService.getFeedItems()
    }
}
