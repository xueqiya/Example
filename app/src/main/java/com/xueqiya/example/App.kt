package com.xueqiya.example

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.blankj.utilcode.util.ProcessUtils
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    companion object {
        lateinit var application: Application
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
        application = this
    }

    override fun onCreate() {
        super.onCreate()
        if (packageName == ProcessUtils.getCurrentProcessName()) {
            init()
        }
    }

    private fun init() {

    }
}