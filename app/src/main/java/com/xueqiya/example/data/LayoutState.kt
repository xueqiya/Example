package com.xueqiya.example.data

sealed class LayoutState(val msg: String) {
    class Loading(msg: String = "") : LayoutState(msg)
    class Empty(msg: String = "") : LayoutState(msg)
    class Success(msg: String = "") : LayoutState(msg)
    class Fail(msg: String) : LayoutState(msg)
}