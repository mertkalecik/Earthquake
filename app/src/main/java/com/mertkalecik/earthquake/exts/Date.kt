@file:Suppress("DEPRECATION")

package com.mertkalecik.earthquake.exts

import java.text.SimpleDateFormat
import java.util.*

fun getRequestDate(): Pair<String, String> {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val startDate = Date()
    val endDate = Date().also { it.month -= 2 }

    return (dateFormat.format(endDate) to dateFormat.format(startDate))
}