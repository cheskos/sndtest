package com.evite.giphytest.ui

import android.os.Bundle
import com.evite.giphytest.R
import com.evite.giphytest.base.BaseFragment

class SearchGifsFragment : BaseFragment() {

    override fun getLayout(): Int = R.layout.fragment_search_gifs

    companion object {
        @JvmStatic fun newInstance(): SearchGifsFragment {
            return SearchGifsFragment().apply {
                arguments = Bundle().apply {

                }
            }
        }
    }
}