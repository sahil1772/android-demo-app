package com.example.bugdemo.ui.profile

import com.example.bugdemo.data.local.AppDatabase
import com.example.bugdemo.data.model.User
import com.example.bugdemo.data.remote.ApiClient

class ProfileRepository {
    private val apiClient = ApiClient()
    private val db = AppDatabase.getInstance()

    suspend fun getProfile(): User? {
        val remoteUser = apiClient.getProfile()
        if (remoteUser != null) {
            db.userDao().updateUser(remoteUser)
        }
        return remoteUser ?: db.userDao().getCurrentUser()
    }

    suspend fun updateProfile(name: String, email: String): Boolean {
        val updated = apiClient.updateProfile(name, email)
        if (updated) {
            db.userDao().updateUserFields(name, email)
        }
        return updated
    }
}
