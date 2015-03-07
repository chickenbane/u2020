package com.googlejobapp.u2020.data.prefs

import android.content.SharedPreferences

/**
 * Created by joeyt on 3/7/15.
 */
class IntPreference(private val preferences: SharedPreferences,
                    private val key: String,
                    private val defaultValue: Int = 0) {

    fun get(): Int = preferences.getInt(key, defaultValue)

    fun set(value: Int) = preferences.edit().putInt(key, value).apply()

    fun isSet(): Boolean = preferences.contains(key)

    fun delete() = preferences.edit().remove(key).apply()
}