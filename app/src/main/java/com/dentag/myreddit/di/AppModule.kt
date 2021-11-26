package com.dentag.myreddit.di

import android.content.Context
import androidx.room.Room
import com.dentag.myreddit.data.database.RedditDatabase
import com.dentag.myreddit.ext.Dispatchers
import com.dentag.myreddit.network.RedditService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
object AppModule {

    @Singleton
    @Provides
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Singleton
    @Provides
    fun provideRedditService(moshi: Moshi): RedditService {
        val httpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.reddit.com/r/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(httpClient)
            .build()

        return retrofit.create(RedditService::class.java)
    }

    @Singleton
    @Provides
    fun provideDispatchers(): Dispatchers {
        return Dispatchers.Default
    }

    @Singleton
    @Provides
    fun provideDatabase(
        appContext: Context
    ): RedditDatabase {
        return Room.databaseBuilder(
            appContext,
            RedditDatabase::class.java,
            "reddit_db"
        ).build()
    }
}