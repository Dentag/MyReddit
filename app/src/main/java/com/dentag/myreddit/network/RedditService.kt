package com.dentag.myreddit.network

import com.dentag.myreddit.data.network.HotResponse
import retrofit2.Response
import retrofit2.http.GET

interface RedditService {

    @GET("aww/hot.json")
    suspend fun getHotMessages(): Response<HotResponse>
}