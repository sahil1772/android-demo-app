package com.example.bugdemo

import android.app.Application

class BugDemoApp : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: BugDemoApp
            private set
    }
}
