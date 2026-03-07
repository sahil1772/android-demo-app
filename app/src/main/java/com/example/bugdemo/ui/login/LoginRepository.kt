package com.example.bugdemo.ui.login

import com.example.bugdemo.data.model.User
import com.example.bugdemo.data.remote.ApiClient

class LoginRepository {
    private val apiClient = ApiClient()

    suspend fun authenticate(username: String, password: String): User? {
        val response = apiClient.login(username, password)

        if (response != null && response.password == password) {
            return response
        }

        return null
    }
}
