package com.snd.test.di;

import com.snd.test.ui.search.MainActivity;
import com.snd.test.ui.search.MainModule;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivitiesModule {

    @ActivityScope @ContributesAndroidInjector(modules = MainModule.class)
    abstract MainActivity mainActivity();
}
