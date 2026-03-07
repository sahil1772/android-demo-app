package com.example.bugdemo.ui.profile

import androidx.lifecycle.ViewModel
import com.example.bugdemo.data.model.User

class ProfileViewModel : ViewModel() {
    private val repository = ProfileRepository()

    suspend fun loadProfile(): User? {
        return repository.getProfile()
    }

    suspend fun updateProfile(name: String, email: String): Boolean {
        return repository.updateProfile(name, email)
    }
}
