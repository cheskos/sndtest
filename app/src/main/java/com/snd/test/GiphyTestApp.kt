package com.snd.test

import android.app.Activity
import android.app.Application
import com.snd.test.di.AppComponent
import com.snd.test.di.AppModule
import com.snd.test.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class GiphyTestApp : Application(), HasActivityInjector {

    @Inject internal lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    private val component: AppComponent by lazy {
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector

    override fun onCreate() {
        super.onCreate()

        component.inject(this)
    }
}