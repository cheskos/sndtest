package com.evite.giphytest.ui

import android.os.Bundle
import com.evite.giphytest.R
import com.evite.giphytest.base.BaseFragment
import com.evite.giphytest.model.GifData

class GifsResultFragment : BaseFragment() {

    private val gifList = arrayListOf<GifData.Images>()

    override fun getLayout(): Int = R.layout.list_gif

    companion object {
        const val PARAM_LIST = "ALL_GIF_LIST"

        @JvmStatic fun newInstance(list: List<GifData.Images>): GifsResultFragment {
            return GifsResultFragment().apply {
                arguments = Bundle().apply {
                    putParcelableArrayList(PARAM_LIST, ArrayList<GifData.Images>(list))
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        gifList.addAll(arguments.getParcelableArrayList(PARAM_LIST))
    }

    override fun setupViews(savedInstanceState: Bundle?) {
        val savedList = savedInstanceState?.getParcelableArrayList<GifData.Images>(PARAM_LIST)
        if (savedList != null) {
            gifList.clear()
            gifList.addAll(savedList)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelableArrayList(PARAM_LIST, gifList)
    }
}