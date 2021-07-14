package com.xueqiya.example.base

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.xueqiya.example.dialog.LoadingDialog

abstract class BaseFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        initData()
        return initView(inflater, container, savedInstanceState)?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initObserver()
        getData()
    }

    private var dialog: LoadingDialog? = null
    fun showDialog() {
        if (dialog == null) {
            dialog = LoadingDialog(requireActivity())
        }
        dialog?.show()
    }

    fun dismissDialog() {
        dialog?.dismiss()
    }

    protected val bundleKey = "bundleKey"
    fun startActivity(clazz: Class<out AppCompatActivity>, bundle: Bundle? = Bundle()) {
        val intent = Intent(requireActivity(), clazz)
        intent.putExtra(bundleKey, bundle)
        startActivity(intent)
    }

    protected abstract fun initData()
    protected abstract fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): ViewBinding?
    protected abstract fun initObserver()
    protected open fun getData() {}
}