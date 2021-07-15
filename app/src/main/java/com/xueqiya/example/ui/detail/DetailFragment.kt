package com.xueqiya.example.ui.detail

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.transition.TransitionInflater
import androidx.viewbinding.ViewBinding
import com.hi.dhl.binding.viewbind
import com.xueqiya.example.base.BaseFragment
import com.xueqiya.example.databinding.FragmentDetailBinding
import com.xueqiya.example.utils.ext.initToolBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseFragment() {
    private val viewModel: DetailViewModel by viewModels()
    private val binding: FragmentDetailBinding by viewbind()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            sharedElementEnterTransition = TransitionInflater.from(requireContext())
                .inflateTransition(android.R.transition.move)
        }
    }

    override fun initData() {
    }

    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): ViewBinding {
        return binding.apply {
            toolbar.toolbar.initToolBar("Detail")
        }
    }

    override fun initObserver() {
        viewModel.run {

        }
    }
}