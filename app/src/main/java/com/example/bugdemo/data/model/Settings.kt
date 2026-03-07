package com.example.bugdemo.data.model

data class Settings(
    val darkMode: Boolean = false,
    val notificationsEnabled: Boolean = true,
    val language: String = "en",
    val fontSize: Int = 14
)
