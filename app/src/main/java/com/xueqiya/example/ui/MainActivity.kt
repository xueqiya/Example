package com.xueqiya.example.ui

import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.xueqiya.example.R
import com.xueqiya.example.base.BaseActivity
import com.xueqiya.example.databinding.ActivityMainBinding
import com.hi.dhl.binding.viewbind

class MainActivity : BaseActivity() {
    private val binding: ActivityMainBinding by viewbind()
    private lateinit var navController: NavController

    override fun initData() {
    }

    override fun initView() {
        binding.run {
            navController = findNavController(R.id.nav_host_fragment)
            navView.setupWithNavController(navController)
        }
    }

    override fun initObserver() {
    }

    override fun onBackPressed() {
//        super.onBackPressed()
        if (navController.currentDestination?.id == R.id.navigation_home ||
            navController.currentDestination?.id == R.id.navigation_dashboard ||
            navController.currentDestination?.id == R.id.navigation_notifications
        ) {
            moveTaskToBack(false)
        } else {
            navController.navigateUp()
        }
    }
}