package com.example.bugdemo.ui.settings

import androidx.lifecycle.ViewModel

class SettingsViewModel : ViewModel() {
    private val prefs = PreferenceManager.getInstance()
    private var cachedDarkMode: Boolean = prefs.getDarkMode()
    private var cachedNotifications: Boolean = prefs.getNotificationsEnabled()

    fun isDarkMode(): Boolean = cachedDarkMode

    fun isNotificationsEnabled(): Boolean = cachedNotifications

    fun setDarkMode(enabled: Boolean) {
        prefs.setDarkMode(enabled)
    }

    fun setNotificationsEnabled(enabled: Boolean) {
        cachedNotifications = enabled
        prefs.setNotificationsEnabled(enabled)
    }
}
