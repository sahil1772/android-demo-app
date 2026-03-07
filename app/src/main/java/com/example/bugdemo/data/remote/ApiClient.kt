package com.example.bugdemo.data.remote

import com.example.bugdemo.data.model.User
import com.google.gson.Gson
import java.net.HttpURLConnection
import java.net.URL
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ApiClient {
    private val baseUrl = "https://api.example.com"
    private val gson = Gson()

    suspend fun login(username: String, password: String): User? {
        return withContext(Dispatchers.IO) {
            try {
                val response = post("/api/auth/login", mapOf(
                    "username" to username,
                    "password" to password
                ))
                gson.fromJson(response, User::class.java)
            } catch (e: Exception) {
                throw e
            }
        }
    }

    suspend fun getProfile(): User? {
        return withContext(Dispatchers.IO) {
            try {
                val response = get("/api/users/profile")
                gson.fromJson(response, User::class.java)
            } catch (e: Exception) {
                null
            }
        }
    }

    suspend fun updateProfile(name: String, email: String): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                post("/api/users/profile", mapOf("name" to name, "email" to email))
                true
            } catch (e: Exception) {
                false
            }
        }
    }

    suspend fun get(path: String): String {
        return withContext(Dispatchers.IO) {
            val url = URL("$baseUrl$path")
            val conn = url.openConnection() as HttpURLConnection
            conn.requestMethod = "GET"
            conn.setRequestProperty("Content-Type", "application/json")
            conn.inputStream.bufferedReader().readText()
        }
    }

    private suspend fun post(path: String, body: Map<String, String>): String {
        return withContext(Dispatchers.IO) {
            val url = URL("$baseUrl$path")
            val conn = url.openConnection() as HttpURLConnection
            conn.requestMethod = "POST"
            conn.setRequestProperty("Content-Type", "application/json")
            conn.doOutput = true
            conn.outputStream.write(gson.toJson(body).toByteArray())
            conn.inputStream.bufferedReader().readText()
        }
    }
}
