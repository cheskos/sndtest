package com.evite.giphytest.ui;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent
public interface MainSubComponent extends AndroidInjector<SearchGifsFragment> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<SearchGifsFragment> {}
}
