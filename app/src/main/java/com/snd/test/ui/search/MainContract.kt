package com.snd.test.ui.search

import com.snd.test.base.BaseView
import com.snd.test.model.PostResponseData

interface MainContract {

    interface View : BaseView {
        fun displayResult(result: List<PostResponseData.Post>)
        fun selected(isSelected: Boolean, item: PostResponseData.Post)
    }

    interface Presenter {
        fun search(word: String, offset: Int, limit: Int)
    }
}