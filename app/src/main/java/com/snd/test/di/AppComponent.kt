package com.snd.test.di

import android.content.Context
import com.snd.test.AppExecutors
import com.snd.test.SndTestApp
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

//@ApplicationScope
@Singleton
@Component(modules = [
    AndroidInjectionModule::class
    ,AppModule::class
    ,ActivitiesModule::class
    ,ApiServiceModule::class
    ,ReposModule::class
])
interface AppComponent {
    fun app(): SndTestApp

    fun context(): Context

    fun appExecutors(): AppExecutors

    fun inject(app: SndTestApp)
}