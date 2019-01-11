package com.evite.giphytest.di;

import com.evite.giphytest.ui.MainActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivitiesModule {

    @ActivityScope @ContributesAndroidInjector
    abstract MainActivity mainActivity();
}
