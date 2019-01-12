package com.evite.giphytest.ui;

import android.app.Fragment;
import com.evite.giphytest.repositories.GifsRepo;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.AndroidInjector;
import dagger.android.FragmentKey;
import dagger.multibindings.IntoMap;
import org.jetbrains.annotations.NotNull;

@Module(subcomponents = MainSubComponent.class)
public abstract class MainModule {

    @Binds @IntoMap @FragmentKey(GifsResultFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> bindSearchFragment(MainSubComponent.Builder builder);

    @Provides static MainContract.View provideView(MainActivity activity) {
        return activity;
    }

    @Provides @NotNull static MainPresenter provideMainPresenter(GifsRepo repo, MainContract.View view) {
        return new MainPresenter(repo, view);
    }
}
