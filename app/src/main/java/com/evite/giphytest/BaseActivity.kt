package com.evite.giphytest

import android.app.Activity
import android.os.Bundle
import dagger.android.AndroidInjection

abstract class BaseActivity : Activity() {

    abstract fun getLayout(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
    }
}