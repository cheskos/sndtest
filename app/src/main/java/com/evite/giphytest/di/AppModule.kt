package com.evite.giphytest.di

import android.content.Context
import com.evite.giphytest.AppExecutors
import com.evite.giphytest.GiphyTestApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: GiphyTestApp) {

    @Provides @Singleton fun provideApp(): GiphyTestApp = app

    @Provides @Singleton fun provideContext(): Context = app

    @Provides @Singleton fun provideExecutors(): AppExecutors = AppExecutors()

}