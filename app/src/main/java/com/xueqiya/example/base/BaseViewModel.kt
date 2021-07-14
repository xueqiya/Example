package com.xueqiya.example.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.xueqiya.example.utils.Event
import com.xueqiya.example.data.LayoutState

open class BaseViewModel : ViewModel() {
    protected val _layoutEvent = MutableLiveData<LayoutState>()
    val layoutEvent: LiveData<LayoutState> = _layoutEvent

    protected val _loadDialogEvent = MutableLiveData<Event<Boolean>>()
    val loadDialogEvent: LiveData<Event<Boolean>> = _loadDialogEvent

    protected val _keyboardEvent = MutableLiveData<Event<Boolean>>()
    val keyboardEvent: LiveData<Event<Boolean>> = _keyboardEvent

    protected val _snackBarEvent = MutableLiveData<Event<String>>()
    val snackBarEvent: LiveData<Event<String>> = _snackBarEvent

    protected val _finishEvent = MutableLiveData<Event<Unit>>()
    val finishEvent: LiveData<Event<Unit>> = _finishEvent
}