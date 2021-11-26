package com.dentag.myreddit.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.dentag.myreddit.data.Post
import com.dentag.myreddit.data.repos.RedditRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@ExperimentalPagingApi
class MainViewModel @Inject constructor(
    private val redditRepository: RedditRepository
) : ViewModel() {

    private val pager = Pager(
        PagingConfig(100),
        remoteMediator = redditRepository.getRedditRemoteMediator()
    ) {
        redditRepository.getRedditPagingSource()
    }

    val posts: StateFlow<PagingData<Post>> = pager.flow
        .stateIn(viewModelScope, SharingStarted.Lazily, PagingData.empty())
}