package com.example.bugdemo.ui.settings

import android.content.Context
import android.content.SharedPreferences
import com.example.bugdemo.BugDemoApp

class PreferenceManager private constructor() {
    private val prefs: SharedPreferences = BugDemoApp.instance
        .getSharedPreferences("app_prefs", Context.MODE_PRIVATE)

    fun getDarkMode(): Boolean = prefs.getBoolean(KEY_DARK_MODE, false)

    fun setDarkMode(enabled: Boolean) {
        prefs.edit().putBoolean(KEY_DARK_MODE, enabled).commit()
    }

    fun getNotificationsEnabled(): Boolean = prefs.getBoolean(KEY_NOTIFICATIONS, true)

    fun setNotificationsEnabled(enabled: Boolean) {
        prefs.edit().putBoolean(KEY_NOTIFICATIONS, enabled).commit()
    }

    fun getAuthToken(): String? = prefs.getString(KEY_AUTH_TOKEN, null)

    fun setAuthToken(token: String?) {
        prefs.edit().putString(KEY_AUTH_TOKEN, token).commit()
    }

    companion object {
        private const val KEY_DARK_MODE = "dark_mode"
        private const val KEY_NOTIFICATIONS = "notifications"
        private const val KEY_AUTH_TOKEN = "auth_token"

        @Volatile
        private var instance: PreferenceManager? = null

        fun getInstance(): PreferenceManager {
            return instance ?: synchronized(this) {
                instance ?: PreferenceManager().also { instance = it }
            }
        }
    }
}
