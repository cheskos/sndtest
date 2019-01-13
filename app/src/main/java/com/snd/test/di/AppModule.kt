package com.snd.test.di

import android.content.Context
import com.snd.test.AppExecutors
import com.snd.test.SndTestApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: SndTestApp) {

    @Provides @Singleton fun provideApp(): SndTestApp = app

    @Provides @Singleton fun provideContext(): Context = app

    @Provides @Singleton fun provideExecutors(): AppExecutors = AppExecutors()

}