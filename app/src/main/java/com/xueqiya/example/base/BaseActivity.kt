package com.xueqiya.example.base

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.xueqiya.example.dialog.LoadingDialog
import com.blankj.utilcode.util.ColorUtils
import com.jaeger.library.StatusBarUtil
import com.xueqiya.example.utils.theme.Theme
import com.xueqiya.example.utils.theme.ThemeUtils

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val theme = ThemeUtils.getTheme()
        setTheme(theme)
        setBar(theme)
        super.onCreate(savedInstanceState)
        initData()
        initView()
        initObserver()
        getData()
    }

    private fun setTheme(theme: Theme) {
        setTheme(theme.theme)
    }

    private fun setBar(theme: Theme) {
        StatusBarUtil.setColorNoTranslucent(this, ColorUtils.getColor(theme.colorRes))
    }

    private var dialog: LoadingDialog? = null
    fun showDialog() {
        if (dialog == null) {
            dialog = LoadingDialog(this)
        }
        dialog?.show()
    }

    fun dismissDialog() {
        dialog?.dismiss()
    }

    protected val bundleKey = "bundleKey"
    fun startActivity(clazz: Class<out AppCompatActivity>, bundle: Bundle? = Bundle()) {
        val intent = Intent(this, clazz)
        intent.putExtra(bundleKey, bundle)
        startActivity(intent)
    }

    protected abstract fun initData()
    protected abstract fun initView()
    protected abstract fun initObserver()
    protected open fun getData() {}
}