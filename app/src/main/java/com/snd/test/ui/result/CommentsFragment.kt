package com.snd.test.ui.result

import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.snd.test.R
import com.snd.test.model.CommentResponseData
import com.snd.test.ui.CommentsListAdapter
import kotlinx.android.synthetic.main.list_gif.*

class CommentsFragment : Fragment() {

    private val commentsList = arrayListOf<CommentResponseData.Comment>()

    companion object {
        const val PARAM_LIST = "COMMENTS_LIST"

        @JvmStatic fun newInstance(list: List<CommentResponseData.Comment>): CommentsFragment {
            return CommentsFragment().apply {
                arguments = Bundle().apply {
                    putParcelableArrayList(PARAM_LIST, ArrayList<CommentResponseData.Comment>(list))
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        commentsList.addAll(arguments.getParcelableArrayList(PARAM_LIST))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.list_gif, container, false)

        val savedList = savedInstanceState?.getParcelableArrayList<CommentResponseData.Comment>(PARAM_LIST)
        if (savedList != null) {
            commentsList.clear()
            commentsList.addAll(savedList)
        }
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with (recyclerView as RecyclerView) {
            adapter = CommentsListAdapter(commentsList)
            layoutManager = LinearLayoutManager(activity)
            addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelableArrayList(PARAM_LIST, commentsList)
    }
}