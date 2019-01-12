package com.snd.test.base

import android.arch.lifecycle.LifecycleOwner
import android.os.Bundle
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.snd.test.coordinator
import dagger.android.AndroidInjection

abstract class BaseActivity : AppCompatActivity(), BaseView {

    abstract fun getLayout(): Int
    abstract fun getPresenter(): BasePresenter?

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        getPresenter()?.attachLifecycle(lifecycle)
    }

    override fun onDestroy() {
        super.onDestroy()
        getPresenter()?.detachLifecycle(lifecycle)
    }

    override fun lifecycleOwner(): LifecycleOwner = this

    override fun showMessage(messageResource: Int) {
        showMessage(getString(messageResource))
    }

    override fun showMessage(message: String) {
        if (coordinator != null) {
            Snackbar.make(coordinator as CoordinatorLayout, message, Snackbar.LENGTH_LONG)
                .show()
        } else {
            Toast.makeText(this, message, Toast.LENGTH_LONG)
                .show()
        }
    }
}