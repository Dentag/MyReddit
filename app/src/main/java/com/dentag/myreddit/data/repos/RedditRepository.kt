package com.dentag.myreddit.data.repos

import androidx.paging.ExperimentalPagingApi
import com.dentag.myreddit.data.RedditPagingSource
import com.dentag.myreddit.data.RedditRemoteMediator

interface RedditRepository {
    fun getRedditPagingSource(): RedditPagingSource
    @ExperimentalPagingApi
    fun getRedditRemoteMediator(): RedditRemoteMediator
}