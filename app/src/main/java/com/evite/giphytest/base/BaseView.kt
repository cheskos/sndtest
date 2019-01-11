package com.evite.giphytest.base

import android.arch.lifecycle.LifecycleOwner
import android.support.annotation.StringRes

interface BaseView {
    fun lifecycleOwner(): LifecycleOwner
    fun showMessage(@StringRes messageResource: Int)
    fun showMessage(message: String)
    fun showProgressBar(show: Boolean)
}