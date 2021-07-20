package com.xueqiya.example.utils.theme

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.xueqiya.example.App.Companion.application

/**
 * @Author xueqi
 * @Date 2021/7/19 4:12 下午
 * @Description: TODO
 */
@SuppressLint("CommitPrefEdits")
object ThemeUtils {
    private var preferences: SharedPreferences
    private var settingPreferences: SharedPreferences
    private var edit: SharedPreferences.Editor

    init {
        val spName = "THEME_SP"
        preferences = application.getSharedPreferences(spName, Context.MODE_PRIVATE)
        edit = preferences.edit()
        settingPreferences = PreferenceManager.getDefaultSharedPreferences(application)
    }

    //是否第一次打开
    private const val themeKey = "themeKey"
    fun setTheme(theme: Theme) {
        edit.putInt(themeKey, theme.id)
        edit.apply()
    }

    fun getTheme(): Theme {
        val themeId = preferences.getInt(themeKey, 1)
        return getTheme(themeId)
    }

    private fun getTheme(id: Int): Theme {
        var theme: Theme? = null
        Theme.values().forEach {
            if (it.id == id) {
                theme = it
            }
        }
        return theme ?: Theme.Teal
    }
}