package com.evite.giphytest.base

import android.arch.lifecycle.LifecycleOwner
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection

abstract class BaseActivity : AppCompatActivity(), BaseView {

    abstract fun getLayout(): Int
    abstract fun getPresenter(): BasePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        getPresenter()
            .attachLifecycle(lifecycle)
    }

    override fun onDestroy() {
        super.onDestroy()
        getPresenter()
            .detachLifecycle(lifecycle)
    }

    override fun lifecycleOwner(): LifecycleOwner = this
}