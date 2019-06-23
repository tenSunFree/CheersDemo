package com.home.cheersdemo

import android.app.Application

class CheersDemoApplication : Application() {

    companion object {
        lateinit var instance: CheersDemoApplication
            private set // set方法 不對外公開
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}
