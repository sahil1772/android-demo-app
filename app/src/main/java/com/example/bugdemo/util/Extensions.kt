package com.example.bugdemo.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun String.toFormattedDate(): String {
    return try {
        val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
        val formatter = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
        val date = parser.parse(this)
        formatter.format(date ?: Date())
    } catch (e: Exception) {
        this
    }
}

fun Double.toCurrencyString(): String {
    return String.format("%.2f", this)
}
