package com.example.bugdemo.data.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id")
    val id: Int = 0,

    @SerializedName("username")
    val username: String = "",

    @SerializedName("email_address")
    val email: String? = null,

    @SerializedName("name")
    val name: String = "",

    @SerializedName("password")
    val password: String = "",

    @SerializedName("avatar_url")
    val avatarUrl: String? = null,

    @SerializedName("status")
    val status: String = "active"
)
