package com.snd.test.ui.result

import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.snd.test.R
import com.snd.test.model.PostResponseData
import com.snd.test.ui.GifsListAdapter
import kotlinx.android.synthetic.main.list_gif.*

class GifsResultFragment : Fragment() {

    private val gifList = arrayListOf<PostResponseData.Post>()

    companion object {
        const val PARAM_LIST = "ALL_GIF_LIST"

        @JvmStatic fun newInstance(list: List<PostResponseData.Post>): GifsResultFragment {
            return GifsResultFragment().apply {
                arguments = Bundle().apply {
                    putParcelableArrayList(PARAM_LIST, ArrayList<PostResponseData.Post>(list))
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        gifList.addAll(arguments.getParcelableArrayList(PARAM_LIST))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.list_gif, container, false)

        val savedList = savedInstanceState?.getParcelableArrayList<PostResponseData.Post>(PARAM_LIST)
        if (savedList != null) {
            gifList.clear()
            gifList.addAll(savedList)
        }
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with (recyclerView as RecyclerView) {
            adapter = GifsListAdapter(gifList, null)
            layoutManager = GridLayoutManager(activity, 2)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelableArrayList(PARAM_LIST, gifList)
    }
}