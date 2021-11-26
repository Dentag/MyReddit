package com.dentag.myreddit.data.network

import com.squareup.moshi.Json

class PostDto(
    val id: String,
    @Json(name = "author_fullname")
    val authorFullName: String,
    val title: String,
    @Json(name = "upvote_ratio")
    val upvoteRatio: Double,
    @Json(name = "num_comments")
    val numComments: Long
)
