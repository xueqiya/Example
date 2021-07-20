package com.xueqiya.example.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.xueqiya.example.base.BaseFragment
import com.xueqiya.example.databinding.FragmentNotificationsBinding
import com.hi.dhl.binding.viewbind
import com.xueqiya.example.utils.ext.initToolBar

class NotificationsFragment : BaseFragment() {
    private lateinit var viewModel: NotificationsViewModel
    private val binding: FragmentNotificationsBinding by viewbind()

    override fun initData() {
        viewModel = ViewModelProvider(requireActivity()).get(NotificationsViewModel::class.java)
    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): ViewBinding? {
        return binding.apply {
            toolbar.toolbar.initToolBar("Notifications")
        }
    }

    override fun initObserver() {
        binding.run {
            viewModel.text.observe(viewLifecycleOwner, Observer {
                textNotifications.text = it
            })
        }
    }

    override fun getData() {
    }
}