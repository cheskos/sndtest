package com.snd.test.ui.search

import com.snd.test.base.BaseView
import com.snd.test.model.GifData

interface MainContract {

    interface View : BaseView {
        fun displayResult(result: List<GifData>)
        fun selected(isSelected: Boolean, item: GifData)
    }

    interface Presenter {
        fun search(word: String, offset: Int, limit: Int)
    }
}