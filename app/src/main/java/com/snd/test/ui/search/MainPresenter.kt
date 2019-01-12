package com.snd.test.ui.search

import android.arch.lifecycle.Observer
import com.snd.test.base.BasePresenter
import com.snd.test.model.SearchResponseData
import com.snd.test.repositories.GifsRepo
import javax.inject.Inject

class MainPresenter @Inject internal constructor(
    private val gifsRepo: GifsRepo,
    private val mainView: MainContract.View
): BasePresenter(), MainContract.Presenter {

    private val resultObserver = Observer<SearchResponseData> { response ->
        if (response == null) {
            mainView.showMessage("Error in response")
        } else {
            mainView.displayResult(response.data)
        }
    }

    override fun onStart() {
        gifsRepo.gifResults.observe(mainView.lifecycleOwner(), resultObserver)
    }

    override fun search(word: String, offset: Int, limit: Int) {
        gifsRepo.search(word, offset, limit)
    }

    override fun onStop() {
        gifsRepo.gifResults.removeObserver(resultObserver)
    }
}