package com.dentag.myreddit.data

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.bumptech.glide.load.HttpException
import com.dentag.myreddit.data.database.RedditDatabase
import com.dentag.myreddit.network.RedditService
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@ExperimentalPagingApi
@Singleton
class RedditRemoteMediator @Inject constructor(
    private val redditDatabase: RedditDatabase,
    private val redditService: RedditService
) : RemoteMediator<Int, Post>() {

    private val postDao = redditDatabase.postDao()

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, Post>
    ): MediatorResult {
        return try {
            when (loadType) {
                LoadType.REFRESH -> {
                }
                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> {
                }
            }
            val response = redditService.getHotMessages().body()!!.mapToPostList()
            postDao.insertAll(response)
            MediatorResult.Success(endOfPaginationReached = false)
        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }
}