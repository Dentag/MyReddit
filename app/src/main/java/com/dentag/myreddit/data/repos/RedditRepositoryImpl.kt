package com.dentag.myreddit.data.repos

import androidx.paging.ExperimentalPagingApi
import com.dentag.myreddit.data.RedditPagingSource
import com.dentag.myreddit.data.RedditRemoteMediator
import javax.inject.Inject
import javax.inject.Singleton

@ExperimentalPagingApi
@Singleton
class RedditRepositoryImpl @Inject constructor(
    private val redditPagingSource: RedditPagingSource,
    private val redditRemoteMediator: RedditRemoteMediator
) : RedditRepository {
    override fun getRedditPagingSource(): RedditPagingSource {
        return redditPagingSource
    }

    @ExperimentalPagingApi
    override fun getRedditRemoteMediator(): RedditRemoteMediator {
        return redditRemoteMediator
    }
}