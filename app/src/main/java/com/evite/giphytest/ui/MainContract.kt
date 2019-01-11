package com.evite.giphytest.ui

import com.evite.giphytest.base.BaseView

interface MainContract {

    interface View : BaseView {
        fun displayResult(result: List<Any>)
    }

    interface Presenter {
        fun search(word: String, limit: Int)
    }
}