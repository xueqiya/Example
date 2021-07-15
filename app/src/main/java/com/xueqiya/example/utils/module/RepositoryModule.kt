package com.xueqiya.example.utils.module

import com.xueqiya.example.data.remote.RemoteDataSource
import com.xueqiya.example.data.repository.HomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideHomeRepository(remoteDataSource: RemoteDataSource): HomeRepository {
        return HomeRepository(remoteDataSource)
    }
}