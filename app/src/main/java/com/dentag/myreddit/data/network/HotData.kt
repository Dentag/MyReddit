package com.dentag.myreddit.data.network

import com.squareup.moshi.Json

class HotData(
    @Json(name = "children")
    val posts: List<HotChildren>
)