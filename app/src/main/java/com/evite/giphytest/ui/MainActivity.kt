package com.evite.giphytest.ui

import android.app.Fragment
import android.os.Bundle
import com.evite.giphytest.R
import com.evite.giphytest.base.BaseActivity
import com.evite.giphytest.base.BasePresenter
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasFragmentInjector
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView, HasFragmentInjector {

    @Inject internal lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    @Inject lateinit var presenter: MainPresenter

    override fun fragmentInjector(): AndroidInjector<Fragment> = dispatchingAndroidInjector

    override fun getLayout(): Int = R.layout.activity_main

    override fun getPresenter(): BasePresenter = presenter

    override fun displayResults() {

    }

    override fun onStart() {
        super.onStart()
        presenter.search("a", 1)
    }

    override fun showMessage(messageResource: Int) {

    }

    override fun showMessage(message: String) {

    }

    override fun showProgressBar(show: Boolean) {

    }
}