package com.example.bugdemo.data.local

import com.example.bugdemo.data.model.User

class UserDao {
    private var currentUser: User? = null

    fun getCurrentUser(): User? = currentUser

    fun updateUser(user: User) {
        currentUser = user
    }

    fun updateUserFields(name: String, email: String) {
        val existing = currentUser ?: return
        if (existing.id <= 0) return
        currentUser = existing.copy(name = name, email = email)
    }

    fun deleteUser() {
        currentUser = null
    }
}
