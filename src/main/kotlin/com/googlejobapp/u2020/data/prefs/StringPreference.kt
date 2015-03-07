package com.googlejobapp.u2020.data.prefs

import android.content.SharedPreferences

/**
 * Created by joeyt on 3/7/15.
 */
class StringPreference(private val preferences: SharedPreferences,
                       private val key: String,
                       private val defaultValue: String? = null) {

    fun get(): String? = preferences.getString(key, defaultValue)

    fun set(value: String) = preferences.edit().putString(key, value).apply()

    fun isSet(): Boolean = preferences.contains(key)

    fun delete() = preferences.edit().remove(key).apply()
}