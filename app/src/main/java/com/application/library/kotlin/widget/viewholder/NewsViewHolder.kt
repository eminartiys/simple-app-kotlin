package com.application.library.kotlin.widget.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.application.library.kotlin.model.NewsResponse
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.view_news_item.view.*

class NewsViewHolder internal constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

    private lateinit var newsItem: NewsResponse.News

    fun bindView(newsItem: NewsResponse.News) : Unit {
        this.newsItem = newsItem

        itemView.title.text = newsItem.title
        itemView.author.text = newsItem.author

        newsItem.description?.let { itemView.description.text = newsItem.description }

        newsItem.urlToImage?.let {
            Picasso.with(itemView.context)
                    .load(newsItem.urlToImage)
                    .fit()
                    .centerCrop()
                    .noFade()
                    .into(itemView.image)
        }

    }
}