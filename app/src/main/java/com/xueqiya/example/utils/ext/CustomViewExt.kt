package com.xueqiya.example.utils.ext

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import com.xueqiya.example.R

//绑定普通的Recyclerview
fun RecyclerView.init(
    layoutManger: RecyclerView.LayoutManager,
    bindAdapter: RecyclerView.Adapter<*>,
    isScroll: Boolean = true
): RecyclerView {
    layoutManager = layoutManger
    setHasFixedSize(true)
    adapter = bindAdapter
    isNestedScrollingEnabled = isScroll
    return this
}

//初始化有返回键的toolbar
fun AppCompatActivity.initToolBarBack(
    titleStr: String = "",
    onBack: (toolbar: MaterialToolbar) -> Unit = { finish() }
): MaterialToolbar {
    val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
    setSupportActionBar(toolbar)
    supportActionBar?.show()
    return toolbar.apply {
        title = titleStr
        setNavigationIcon(R.drawable.ic_back)
        setNavigationOnClickListener {
            onBack.invoke(this)
        }
    }
}

fun MaterialToolbar.initToolBarBack(
    titleStr: String = "",
    onBack: (toolbar: MaterialToolbar) -> Unit = { Navigation.findNavController(this).navigateUp() }
): MaterialToolbar {
    title = titleStr
    setNavigationIcon(R.drawable.ic_back)
    setNavigationOnClickListener {
        onBack.invoke(this)
    }
    return this
}

fun MaterialToolbar.initToolBar(
    titleStr: String = ""
): MaterialToolbar {
    title = titleStr
    return this
}

fun MaterialToolbar.hideToolBar(): MaterialToolbar {
    visibility = View.GONE
    return this
}

fun Fragment.getNavigationResult(key: String): MutableLiveData<String>? {
    return findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData(key)
}

fun Fragment.setNavigationResult(key: String, result: String) {
    findNavController().previousBackStackEntry?.savedStateHandle?.set(key, result)
}