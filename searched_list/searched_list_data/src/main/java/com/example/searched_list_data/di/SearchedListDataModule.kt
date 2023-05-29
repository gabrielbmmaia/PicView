package com.example.searched_list_data.di

import com.example.network.UnsplashApi
import com.example.searched_list_data.repository.SearchedRepositoryImpl
import com.example.searched_list_domain.repository.SearchedRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SearchedListDataModule {

    @Provides
    @Singleton
    fun provideSearchedRepository(
        unsplashApi: UnsplashApi
    ): SearchedRepository {
        return SearchedRepositoryImpl(unsplashApi)
    }
}