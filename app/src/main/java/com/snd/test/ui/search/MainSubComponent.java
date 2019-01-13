package com.snd.test.ui.search;

import com.snd.test.ui.result.GifsResultFragment;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent
public interface MainSubComponent extends AndroidInjector<GifsResultFragment> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<GifsResultFragment> {}
}
