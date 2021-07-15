package com.xueqiya.example.ui.main

import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.xueqiya.example.R
import com.xueqiya.example.base.BaseActivity
import com.xueqiya.example.databinding.ActivityMainBinding
import com.hi.dhl.binding.viewbind
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    private val binding: ActivityMainBinding by viewbind()
    private lateinit var navController: NavController

    override fun initData() {
    }

    override fun initView() {
        binding.run {
            navController = findNavController(R.id.nav_host_fragment)
            navController.addOnDestinationChangedListener(destinationChangedListener)
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

    private val destinationChangedListener = NavController.OnDestinationChangedListener { _, destination, _ ->
        when (destination.id) {
            R.id.navigation_home -> {
                showOtherView(binding.navView)
            }
            R.id.navigation_dashboard -> {
                showOtherView(binding.navView)
            }
            R.id.navigation_notifications -> {
                showOtherView(binding.navView)
            }
            else -> hideOtherView(binding.navView)
        }
    }
}