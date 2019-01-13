package com.snd.test.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.snd.test.R
import com.snd.test.model.CommentResponseData
import kotlinx.android.synthetic.main.item_comment.view.*

class CommentsListAdapter constructor(
    private val list: List<CommentResponseData.Comment>
) : RecyclerView.Adapter<CommentsListAdapter.CommentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_comment, parent, false)
        return CommentViewHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class CommentViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        private val name: TextView = view.tvName
        private val email: TextView = view.tvEmail
        private val body: TextView = view.tvBody

        fun bind(item: CommentResponseData.Comment) {
            name.text = item.name
            email.text = item.email
            body.text = item.body
        }
    }
}
