package com.example.core.extensions

fun String.formatToFirstUppercase(): String {
    var text = this.trim().replaceFirstChar { it.uppercaseChar() }
    if (!text.endsWith(".")) {
        text += "."
    }
    return text
}