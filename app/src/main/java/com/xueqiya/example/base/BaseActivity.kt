package com.xueqiya.example.base

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.xueqiya.example.R
import com.xueqiya.example.dialog.LoadingDialog
import com.blankj.utilcode.util.BarUtils

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setBar()
        setRootViewPadding()
        super.onCreate(savedInstanceState)
        initData()
        initView()
        initObserver()
        getData()
    }

    private fun setBar() {
        BarUtils.setStatusBarColor(window, ContextCompat.getColor(this, R.color.white))
        BarUtils.setStatusBarLightMode(window, true)
        BarUtils.setNavBarLightMode(window, true)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            BarUtils.setNavBarColor(window, ContextCompat.getColor(this, R.color.black))
        }
    }

    private fun setRootViewPadding() {
        val contentView = findViewById<ViewGroup>(android.R.id.content)
        val statusBarHeight: Int = BarUtils.getStatusBarHeight()
        contentView.setPadding(0, statusBarHeight, 0, 0)
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