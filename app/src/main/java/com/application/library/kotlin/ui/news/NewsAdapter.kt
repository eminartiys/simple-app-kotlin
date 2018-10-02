package com.application.library.kotlin.ui.news

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.application.library.kotlin.R
import com.application.library.kotlin.data.api.model.NewsResponse
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.view_news_item.view.*

/**
 * Created by eminartiys on 8/15/17.
 */
class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    private var items : List<NewsResponse.News>? = null

    fun setItems(items: List<NewsResponse.News>?) {
        this.items = items
        notifyItemRangeInserted(0, items!!.size)
    }

    fun clearItems() {
        val count = itemCount
        this.items = null
        notifyItemRangeRemoved(0, count)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bindView(items!![position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(LayoutInflater.from(
                parent!!.context).inflate(R.layout.view_news_item, parent, false))
    }

    override fun getItemCount(): Int {
        return items?.size ?:0
    }

    class NewsViewHolder internal constructor(itemView: View) :
            RecyclerView.ViewHolder(itemView) {

        var newsItem: NewsResponse.News? = null

        fun bindView(newsItem: NewsResponse.News?) : Unit {
            this.newsItem = newsItem

            newsItem!!.title?.let { itemView.title.text = newsItem!!.title }
            newsItem!!.author?.let { itemView.author.text = newsItem!!.author }
            newsItem!!.description?.let { itemView.description.text = newsItem!!.description }

            newsItem!!.urlToImage?.let {
                Picasso.with(itemView.context)
                        .load(newsItem!!.urlToImage)
                        .fit()
                        .centerCrop()
                        .noFade()
                        .into(itemView.image)
            }

        }
    }
}
