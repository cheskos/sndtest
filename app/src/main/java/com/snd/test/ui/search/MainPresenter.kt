package com.snd.test.ui.search

import android.arch.lifecycle.Observer
import com.snd.test.base.BasePresenter
import com.snd.test.model.CommentResponseData
import com.snd.test.model.PostResponseData
import com.snd.test.repositories.MainRepository
import javax.inject.Inject

class MainPresenter @Inject internal constructor(
    private val mainRepository: MainRepository,
    private val mainView: MainContract.View
): BasePresenter(), MainContract.Presenter {

    private val resultObserver = Observer<List<PostResponseData.Post>> { response ->
        if (response == null) {
            mainView.showMessage("Error in response")
        } else {
            mainView.displayPosts(response)
        }
    }

    private val commentsObserver = Observer<List<CommentResponseData.Comment>> { response ->
        if (response == null) {
            mainView.showMessage("Could not get comments")
        } else {
            mainView.onCommentsFetched(response)
        }
    }

    override fun onStart() {
        mainRepository.postsLiveData.observe(mainView.lifecycleOwner(), resultObserver)
        mainRepository.commentsLiveData.observe(mainView.lifecycleOwner(), commentsObserver)
    }

    override fun getPosts() {
        mainRepository.getAllPosts()
    }

    override fun getCommentsForPost(id: Int) {
        mainRepository.getCommentsFor(id)
    }

    override fun onStop() {
        mainRepository.postsLiveData.removeObserver(resultObserver)
        mainRepository.commentsLiveData.removeObserver(commentsObserver)
    }
}