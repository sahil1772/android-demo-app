package com.example.bugdemo.data.model

import com.google.gson.annotations.SerializedName

data class FeedItem(
    @SerializedName("id")
    val id: Int,

    @SerializedName("title")
    val title: String,

    @SerializedName("body")
    val body: String,

    @SerializedName("author")
    val author: String,

    @SerializedName("created_at")
    val createdAt: String,

    @SerializedName("image_url")
    val imageUrl: String? = null
)
