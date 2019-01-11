package com.evite.giphytest.ui

import android.app.Fragment
import com.evite.giphytest.base.BaseActivity
import com.evite.giphytest.R
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasFragmentInjector
import javax.inject.Inject

class MainActivity : BaseActivity(), HasFragmentInjector {

    @Inject internal lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun fragmentInjector(): AndroidInjector<Fragment> = dispatchingAndroidInjector

    override fun getLayout(): Int = R.layout.activity_main


}