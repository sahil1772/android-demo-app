package com.example.bugdemo.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bugdemo.data.model.FeedItem
import com.example.bugdemo.domain.FeedUseCase
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val feedUseCase = FeedUseCase()
    private val _feedItems = MutableLiveData<List<FeedItem>>()
    val feedItems: LiveData<List<FeedItem>> = _feedItems

    fun loadFeed() {
        viewModelScope.launch {
            val items = feedUseCase.getFeed()
            val currentList = _feedItems.value.orEmpty()
            _feedItems.value = (currentList + items).distinctBy { it.id }
        }
    }
}
