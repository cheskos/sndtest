package com.evite.giphytest.ui

import com.evite.giphytest.base.BasePresenter
import com.evite.giphytest.repositories.GifsRepo
import javax.inject.Inject

class MainPresenter @Inject internal constructor(
    private val gifsRepo: GifsRepo,
    private val mainView: MainView
): BasePresenter(), MainContract.Presenter {

    override fun search(word: String, limit: Int) {
        gifsRepo.search(word, 0, 1)
    }
}