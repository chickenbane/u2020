package com.googlejobapp.u2020.util

/**
 * Created by joeyt on 3/1/15.
 */
fun CharSequence?.isBlank(): Boolean {
    return this == null || this.toString().trim().length() == 0
}

fun String.valueOrDefault(default: String): String {
    return if (isBlank()) default else this
}

fun String.truncateAt(length: Int): String {
    return if (this.length() > length) this.substring(0, length) else this
}