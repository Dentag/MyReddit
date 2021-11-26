package com.dentag.myreddit.di

import androidx.paging.ExperimentalPagingApi
import com.dentag.myreddit.data.repos.RedditRepository
import com.dentag.myreddit.data.repos.RedditRepositoryImpl
import dagger.Binds
import dagger.Module

@ExperimentalPagingApi
@Module
interface AppBinders {
    @Binds
    fun bindRedditRepository(inst: RedditRepositoryImpl): RedditRepository
}