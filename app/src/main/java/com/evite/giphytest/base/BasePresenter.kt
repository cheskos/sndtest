package com.evite.giphytest.base

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.util.Log

abstract class BasePresenter : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        Log.i("BasePresenter", "Creating")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        Log.i("BasePresenter", "Pausing")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        Log.i("BasePresenter", "Starting")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        Log.i("BasePresenter", "Stopping")
//        model.unsubscribe()
    }

    fun attachLifecycle(lifecycle: Lifecycle) {
        lifecycle.addObserver(this)
    }

    fun detachLifecycle(lifecycle: Lifecycle) {
        lifecycle.removeObserver(this)
    }
}