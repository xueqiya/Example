package com.xueqiya.example.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.xueqiya.example.base.BaseFragment
import com.xueqiya.example.databinding.FragmentHomeBinding
import com.hi.dhl.binding.viewbind

class HomeFragment : BaseFragment() {
    private lateinit var viewModel: HomeViewModel
    private val binding: FragmentHomeBinding by viewbind()

    override fun initData() {
        viewModel = ViewModelProvider(requireActivity()).get(HomeViewModel::class.java)
    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): ViewBinding? {
        return binding.apply {

        }
    }

    override fun initObserver() {
        binding.run {
            viewModel.text.observe(viewLifecycleOwner, Observer {
                textHome.text = it
            })
        }
    }

    override fun getData() {
    }
}