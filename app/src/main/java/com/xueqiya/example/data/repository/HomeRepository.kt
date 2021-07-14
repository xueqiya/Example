package com.xueqiya.example.data.repository

import com.xueqiya.example.data.remote.RemoteDataSource
import javax.inject.Inject

class HomeRepository @Inject constructor(private val remoteDataSource: RemoteDataSource) {
}