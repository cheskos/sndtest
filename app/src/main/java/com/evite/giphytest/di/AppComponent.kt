package com.evite.giphytest.di

import android.content.Context
import com.evite.giphytest.AppExecutors
import com.evite.giphytest.GiphyTestApp
import com.evite.giphytest.ui.MainModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

//@ApplicationScope
@Singleton
@Component(modules = [
    AndroidInjectionModule::class
    ,AppModule::class
    ,ActivitiesModule::class
    ,MainModule::class
    ,ApiServiceModule::class
    ,ReposModule::class
])
interface AppComponent {
    fun app(): GiphyTestApp

    fun context(): Context

    fun appExecutors(): AppExecutors

    fun inject(app: GiphyTestApp)
}