package com.googlejobapp.u2020.data.prefs

import android.content.SharedPreferences

/**
 * Created by joeyt on 3/7/15.
 */
class BooleanPreference(private val preferences: SharedPreferences,
                        private val key: String,
                        private val defaultValue: Boolean = false) {

    fun get(): Boolean = preferences.getBoolean(key, defaultValue)

    fun set(value: Boolean) = preferences.edit().putBoolean(key, value).apply()

    fun isSet(): Boolean = preferences.contains(key)

    fun delete() = preferences.edit().remove(key).apply()
}