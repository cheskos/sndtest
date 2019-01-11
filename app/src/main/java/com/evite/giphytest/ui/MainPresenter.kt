package com.evite.giphytest.ui

import com.evite.giphytest.repositories.GifsRepo
import javax.inject.Inject

class MainPresenter @Inject constructor(
    gifsRepo: GifsRepo
//    mainView: MainView
): MainContract.Presenter {

    override fun search(word: String, limit: Int) {

    }
}