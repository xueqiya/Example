package com.xueqiya.example.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.xueqiya.example.base.BaseViewModel
import com.xueqiya.example.data.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeRepository: HomeRepository): BaseViewModel() {
    private val _text = MutableLiveData<String>()
    val text: LiveData<String> = _text
}