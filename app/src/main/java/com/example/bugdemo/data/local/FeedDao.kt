package com.example.bugdemo.data.local

import com.example.bugdemo.data.model.FeedItem

class FeedDao {
    private val cachedItems = mutableListOf<FeedItem>()

    fun getAllItems(): List<FeedItem> = cachedItems.toList()

    fun insertAll(items: List<FeedItem>) {
        cachedItems.clear()
        cachedItems.addAll(items)
    }

    fun clearAll() {
        cachedItems.clear()
    }
}
