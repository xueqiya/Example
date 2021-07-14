package com.xueqiya.example.data.remote

import com.xueqiya.example.data.bean.Common
import retrofit2.http.*

interface RemoteDataSource {
    @FormUrlEncoded
    @POST("user/login")
    suspend fun login(@FieldMap map: Map<String, String>): Common
}