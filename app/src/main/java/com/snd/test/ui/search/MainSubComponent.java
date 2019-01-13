package com.snd.test.ui.search;

import com.snd.test.ui.result.CommentsFragment;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent
public interface MainSubComponent extends AndroidInjector<CommentsFragment> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<CommentsFragment> {}
}
