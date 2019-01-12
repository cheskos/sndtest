package com.evite.giphytest.ui.search

import android.animation.Animator
import android.app.Fragment
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.evite.giphytest.R
import com.evite.giphytest.base.BaseActivity
import com.evite.giphytest.base.BasePresenter
import com.evite.giphytest.model.GifData
import com.evite.giphytest.onChange
import com.evite.giphytest.ui.GifsListAdapter
import com.evite.giphytest.ui.result.DisplayResultActivity
import com.evite.giphytest.ui.search.GifsResultFragment.Companion.PARAM_LIST
import com.evite.giphytest.utils.Utils
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View, HasFragmentInjector {

    @Inject internal lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    @Inject lateinit var presenter: MainPresenter
    private val searchAdapter = GifsListAdapter(arrayListOf(), this)
    private val selectedGifs = arrayListOf<GifData>()
    private val columnCount = 2

    override fun fragmentInjector(): AndroidInjector<Fragment> = dispatchingAndroidInjector

    override fun getLayout(): Int = R.layout.activity_main

    override fun getPresenter(): BasePresenter = presenter

    override fun displayResult(result: List<GifData>) {
        searchAdapter.append(result)
        showProgressBar(false)
        Utils.hideKeyboard(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        with (gifList as RecyclerView) {
            adapter = searchAdapter
            layoutManager = GridLayoutManager(this@MainActivity, columnCount)
        }

        searchEditText.onChange { text ->
            if (text.isNotEmpty() and (text.length > 3)) {
                presenter.search(text, searchAdapter.itemCount, 50)
                showProgressBar(true)
            } else {
                searchAdapter.clear()
            }
        }

        fab.setOnClickListener {
            Intent(this, DisplayResultActivity::class.java).apply {
                putParcelableArrayListExtra(PARAM_LIST, selectedGifs)
                startActivity(this)
            }
        }
    }

    override fun selected(isSelected: Boolean, item: GifData) {
        if (isSelected) {
            selectedGifs.add(item)
        } else {
            selectedGifs.remove(item)
        }
        showMessage(String.format("Count: %s", selectedGifs.size))
    }

    override fun showProgressBar(show: Boolean) {
        val animDuration = resources.getInteger(android.R.integer.config_shortAnimTime).toLong()
        progressBar.animate()
            .alpha(if (show) 1f else 0f)
            .setListener(object : Animator.AnimatorListener {
                override fun onAnimationRepeat(animation: Animator?) {}

                override fun onAnimationEnd(animation: Animator?) {
                    progressBar.visibility = if (show) View.VISIBLE else View.GONE
                }

                override fun onAnimationCancel(animation: Animator?) {}

                override fun onAnimationStart(animation: Animator?) {}
            })
            .duration = animDuration
    }

}