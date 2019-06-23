package com.home.cheersdemo.helper

import android.content.Context
import android.preference.PreferenceManager
import com.home.cheersdemo.CheersDemoApplication

object SharedPreferencesManager {

    private val context: Context
        get() = CheersDemoApplication.instance.applicationContext

    private val sharedPreferences by lazy { PreferenceManager.getDefaultSharedPreferences(context) }

    fun getBoolean(preferenceKey: Int, preferenceDefaultValue: Boolean): Boolean {
        return sharedPreferences.getBoolean(context.getString(preferenceKey), preferenceDefaultValue)
    }

    fun putBoolean(preferenceKey: Int, preferenceValue: Boolean) {
        sharedPreferences.edit().putBoolean(context.getString(preferenceKey), preferenceValue).apply()
    }
}