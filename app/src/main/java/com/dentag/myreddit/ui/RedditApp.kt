package com.dentag.myreddit.ui

import android.app.Application
import android.content.Context
import androidx.paging.ExperimentalPagingApi
import com.dentag.myreddit.di.AppComponent
import com.dentag.myreddit.di.DaggerAppComponent

@ExperimentalPagingApi
class RedditApp : Application() {
    private var _appComponent: AppComponent? = null

    val appComponent: AppComponent
        get() = checkNotNull(_appComponent)

    override fun onCreate() {
        super.onCreate()
        _appComponent = DaggerAppComponent.factory()
            .create(this)
    }
}

@ExperimentalPagingApi
val Context.appComponent: AppComponent
    get() = when (this) {
        is RedditApp -> appComponent
        else -> (applicationContext as RedditApp).appComponent
    }