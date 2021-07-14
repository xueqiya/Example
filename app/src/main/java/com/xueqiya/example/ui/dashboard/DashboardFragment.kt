package com.xueqiya.example.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.xueqiya.example.base.BaseFragment
import com.xueqiya.example.databinding.FragmentDashboardBinding
import com.hi.dhl.binding.viewbind

class DashboardFragment : BaseFragment() {
    private lateinit var viewModel: DashboardViewModel
    private val binding: FragmentDashboardBinding by viewbind()

    override fun initData() {
        viewModel = ViewModelProvider(requireActivity()).get(DashboardViewModel::class.java)
    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): ViewBinding {
        return binding.apply {

        }
    }

    override fun initObserver() {
        viewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textDashboard.text = it
        })
    }

    override fun getData() {
    }
}