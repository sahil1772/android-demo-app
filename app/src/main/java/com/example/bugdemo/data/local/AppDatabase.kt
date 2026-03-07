package com.example.bugdemo.data.local

class AppDatabase private constructor() {
    private val userDao = UserDao()
    private val feedDao = FeedDao()

    fun userDao(): UserDao = userDao
    fun feedDao(): FeedDao = feedDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: AppDatabase().also { instance = it }
            }
        }
    }
}
