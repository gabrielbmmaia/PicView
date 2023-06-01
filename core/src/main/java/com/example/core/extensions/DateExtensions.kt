package com.example.core.extensions

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Formata data de pattern: "EEE MMM dd HH:mm:ss zzz yyyy"
 * para "dd • MMMM • yyyy"
 * */
fun Date.toBrazilianDate(): String {
    val inputDate = this.toString()

    val inputFormat = SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH)
    val outputFormat = SimpleDateFormat("dd • MMMM • yyyy", Locale("pt", "BR"))

    val date = inputFormat.parse(inputDate)

    return outputFormat.format(date ?: "")
}