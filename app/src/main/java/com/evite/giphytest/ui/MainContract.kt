package com.evite.giphytest.ui

import com.evite.giphytest.base.BaseView
import com.evite.giphytest.model.GifData

interface MainContract {

    interface View : BaseView {
        fun displayResult(result: List<GifData>)
        fun selected(isSelected: Boolean, item: GifData)
    }

    interface Presenter {
        fun search(word: String, offset: Int, limit: Int)
    }
}