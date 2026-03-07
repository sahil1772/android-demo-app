package com.example.bugdemo.domain

import com.example.bugdemo.data.model.FeedItem
import com.example.bugdemo.ui.home.FeedRepository

class FeedUseCase {
    private val repository = FeedRepository()

    suspend fun getFeed(): List<FeedItem> {
        return repository.fetchFeed()
    }
}
