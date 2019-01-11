package com.evite.giphytest.ui;

import android.app.Fragment;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = MainSubComponent.class)
public abstract class MainModule {

    @Binds @IntoMap @FragmentKey(SearchGifsFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> bindSearchFragment(MainSubComponent.Builder builder);
}
