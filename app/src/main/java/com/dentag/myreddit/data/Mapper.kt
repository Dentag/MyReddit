package com.dentag.myreddit.data

import com.dentag.myreddit.data.network.HotResponse
import com.dentag.myreddit.data.network.PostDto

fun HotResponse.mapToPostList(): List<Post> {
    return data.posts.map { it.postData.mapToPost() }
}

fun PostDto.mapToPost(): Post {
    return Post(
        id,
        authorFullName,
        title,
        upvoteRatio,
        numComments
    )
}