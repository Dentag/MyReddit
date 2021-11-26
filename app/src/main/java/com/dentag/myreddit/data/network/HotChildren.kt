package com.dentag.myreddit.data.network

import com.squareup.moshi.Json

class HotChildren(
    @Json(name = "data")
    val postData: PostDto
)