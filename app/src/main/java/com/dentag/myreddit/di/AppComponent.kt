package com.dentag.myreddit.di

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import com.dentag.myreddit.ui.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@ExperimentalPagingApi
@Singleton
@Component(modules = [AppModule::class, AppBinders::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance appContext: Context): AppComponent
    }
}