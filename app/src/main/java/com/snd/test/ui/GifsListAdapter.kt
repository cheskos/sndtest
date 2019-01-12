package com.snd.test.ui

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.snd.test.R
import com.snd.test.model.GifData
import com.snd.test.ui.search.MainContract
import kotlinx.android.synthetic.main.item_gif_list.view.*

class GifsListAdapter(
    val list: ArrayList<GifData>,
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

    fun append(moreItems: List<GifData>) {
        list.addAll(moreItems)
        notifyDataSetChanged()
    }

    fun clear() {
        list.clear()
        notifyDataSetChanged()
    }

    inner class GifViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        private val gifImageView: ImageView = view.gifContainer

        fun bind(item: GifData) {
            Glide.with(view.context)
                .asGif()
                .load(item.images.properties.url)
                .into(gifImageView)
        }
    }
}