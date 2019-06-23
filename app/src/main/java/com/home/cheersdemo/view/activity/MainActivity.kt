package com.home.cheersdemo.view.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.home.cheersdemo.R
import com.home.cheersdemo.helper.SharedPreferencesManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        alwaysSkipWelcomeActivity()
    }

    /**
     * 之後總是略過WelcomeActivity
     */
    private fun alwaysSkipWelcomeActivity() {
        SharedPreferencesManager.putBoolean(
            R.string.shared_preferences_is_skip_welcome_activity_key, true
        )
    }
}
