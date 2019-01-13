package com.snd.test.ui

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.snd.test.R
import com.snd.test.model.PostResponseData
import com.snd.test.ui.search.MainContract
import kotlinx.android.synthetic.main.item_gif_list.view.*

class GifsListAdapter(
    val list: ArrayList<PostResponseData.Post>,
    private val listener: MainContract.View?
) : RecyclerView.Adapter<GifsListAdapter.GifViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_gif_list, parent, false)
        return GifViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: GifViewHolder, position: Int) {
        with (holder.view) {
            setOnLongClickListener {
                it.isSelected = !isSelected
                it.setBackgroundColor(if (it.isSelected) ContextCompat.getColor(it.context, R.color.colorAccent) else ContextCompat.getColor(it.context, android.R.color.transparent))
                listener?.selected(isSelected, list[position])
                true
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

    inner class GifViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

//        private val imageView: ImageView = view.gifContainer
        private val tv: TextView = view.text

        fun bind(item: PostResponseData.Post) {
//            Picasso.with(view.context)
//                .load(item.id)
//                .into(imageView)

            tv.text = item.body
        }
    }
}