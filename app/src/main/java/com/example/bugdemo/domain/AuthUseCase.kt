package com.example.bugdemo.domain

import com.example.bugdemo.data.model.User
import com.example.bugdemo.ui.login.LoginRepository

class AuthUseCase {
    private val repository = LoginRepository()

    suspend fun login(username: String, password: String): User? {
        return repository.authenticate(username, password)
    }
}
