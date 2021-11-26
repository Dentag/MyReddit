package com.dentag.myreddit.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.dentag.myreddit.network.RedditService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RedditPagingSource @Inject constructor(
    private val redditService: RedditService
) : PagingSource<Int, Post>() {
    override fun getRefreshKey(state: PagingState<Int, Post>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val anchorPage = state.closestPageToPosition(anchorPosition) ?: return null
        return anchorPage.prevKey?.plus(1) ?: anchorPage.nextKey?.minus(1)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Post> {
        return try {
            val pageNumber = params.key ?: INITIAL_PAGE_NUMBER
            val response = redditService.getHotMessages().body()!!.mapToPostList()
            val nextPageNumber = if (response.isEmpty()) null else pageNumber + 1
            val prevPageNumber = if (pageNumber > 1) pageNumber - 1 else null
            LoadResult.Page(response, prevPageNumber, nextPageNumber)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    companion object {
        const val INITIAL_PAGE_NUMBER = 1
    }
}