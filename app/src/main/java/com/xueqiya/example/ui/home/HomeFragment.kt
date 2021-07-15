package com.xueqiya.example.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.xueqiya.example.base.BaseFragment
import com.xueqiya.example.databinding.FragmentHomeBinding
import com.hi.dhl.binding.viewbind
import com.xueqiya.example.R
import com.xueqiya.example.utils.ext.initToolBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment() {
    private lateinit var viewModel: HomeViewModel
    private val binding: FragmentHomeBinding by viewbind()

    override fun initData() {
        viewModel = ViewModelProvider(requireActivity()).get(HomeViewModel::class.java)
    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): ViewBinding? {
        return binding.apply {
            toolbar.toolbar.initToolBar("Home")
            image.setOnClickListener {
                val extras = FragmentNavigatorExtras(image to "image")
                findNavController().navigate(R.id.action_home_to_detail,null,null,extras)
            }
        }
    }

    override fun initObserver() {
        viewModel.run {

        }
    }
}