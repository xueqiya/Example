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
import com.blankj.utilcode.util.ColorUtils
import com.jaeger.library.StatusBarUtil

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setBar()
        super.onCreate(savedInstanceState)
        initData()
        initView()
        initObserver()
        getData()
    }

    private fun setBar() {
        StatusBarUtil.setColorNoTranslucent(this, ColorUtils.getColor(R.color.white))
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