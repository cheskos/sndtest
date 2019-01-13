package com.snd.test.ui.search

import com.snd.test.base.BaseView
import com.snd.test.model.CommentResponseData
import com.snd.test.model.PostResponseData

interface MainContract {

    interface View : BaseView {
        fun displayPosts(result: List<PostResponseData.Post>)
        fun selected(item: PostResponseData.Post)
        fun onCommentsFetched(comments: List<CommentResponseData.Comment>)
    }

    interface Presenter {
        fun getPosts()
        fun getCommentsForPost(id: Int)
    }
}