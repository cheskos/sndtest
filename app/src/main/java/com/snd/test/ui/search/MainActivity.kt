package com.snd.test.ui.search

import android.animation.Animator
import android.app.Fragment
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.snd.test.R
import com.snd.test.base.BaseActivity
import com.snd.test.base.BasePresenter
import com.snd.test.model.CommentResponseData
import com.snd.test.model.PostResponseData
import com.snd.test.ui.PostsListAdapter
import com.snd.test.ui.result.DisplayResultActivity
import com.snd.test.ui.result.CommentsFragment.Companion.PARAM_LIST
import com.snd.test.utils.Utils
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View, HasFragmentInjector {

    @Inject internal lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    @Inject lateinit var presenter: MainPresenter
    private val searchAdapter = PostsListAdapter(arrayListOf(), this)
    private val columnCount = 2

    override fun fragmentInjector(): AndroidInjector<Fragment> = dispatchingAndroidInjector

    override fun getLayout(): Int = R.layout.activity_main

    override fun getPresenter(): BasePresenter = presenter

    override fun displayPosts(result: List<PostResponseData.Post>) {
        searchAdapter.append(result)
        showProgressBar(false)
        Utils.hideKeyboard(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        with (gifList as RecyclerView) {
            adapter = searchAdapter
            layoutManager = GridLayoutManager(this@MainActivity, columnCount)
            addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))
            addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.HORIZONTAL))
        }

        presenter.getPosts()
    }

//    override fun onStart() {
//        super.onStart()
//        presenter.getPosts()
//        showProgressBar(true)
//    }

    override fun selected(item: PostResponseData.Post) {
        showProgressBar(true)
        showMessage("Please wait")
        presenter.getCommentsForPost(item.id)
    }

    override fun onCommentsFetched(comments: List<CommentResponseData.Comment>) {
        showProgressBar(false)
        Intent(this, DisplayResultActivity::class.java).apply {
            putParcelableArrayListExtra(PARAM_LIST, ArrayList<CommentResponseData.Comment>(comments))
            startActivity(this)
        }
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