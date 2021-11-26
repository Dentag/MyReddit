package com.dentag.myreddit.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dentag.myreddit.data.Post

private const val DATABASE_VERSION = 1

@Database(
    entities = [Post::class],
    version = DATABASE_VERSION
)
abstract class RedditDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
}