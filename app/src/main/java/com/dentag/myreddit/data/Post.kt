package com.dentag.myreddit.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Post(
    @PrimaryKey val id: String,
    val authorFullName: String,
    val title: String,
    val upvoteRatio: Double,
    val numComments: Long
)