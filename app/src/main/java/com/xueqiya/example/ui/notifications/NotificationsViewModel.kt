package com.xueqiya.example.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.xueqiya.example.base.BaseViewModel

class NotificationsViewModel : BaseViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is notifications Fragment"
    }
    val text: LiveData<String> = _text
}