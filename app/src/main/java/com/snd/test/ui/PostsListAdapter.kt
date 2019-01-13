package com.snd.test.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.snd.test.R
import com.snd.test.model.PostResponseData
import com.snd.test.ui.search.MainContract
import kotlinx.android.synthetic.main.item_post.view.*

class PostsListAdapter(
    val list: ArrayList<PostResponseData.Post>,
    private val listener: MainContract.View?
) : RecyclerView.Adapter<PostsListAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        with (holder.view) {
            setOnClickListener {
                listener?.selected(list[position])
            }
        }
        holder.bind(list[position])
    }

    fun append(moreItems: List<PostResponseData.Post>) {
        list.addAll(moreItems)
        notifyDataSetChanged()
    }

    fun clear() {
        list.clear()
        notifyDataSetChanged()
    }

    inner class PostViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        private val title: TextView = view.tvTitle
        private val body: TextView = view.tvBody

        fun bind(item: PostResponseData.Post) {
            title.text = item.title
            body.text = item.body
        }
    }
}