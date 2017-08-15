package com.application.library.kotlin.ui.news

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.application.library.kotlin.R
import com.application.library.kotlin.data.api.model.NewsResponse
import com.squareup.picasso.Picasso

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

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): NewsViewHolder {
        return NewsViewHolder(LayoutInflater.from(
                parent!!.context).inflate(R.layout.view_news_item, parent, false))
    }

    override fun getItemCount(): Int {
        return items?.size ?:0
    }

    class NewsViewHolder internal constructor(itemView: View) :
            RecyclerView.ViewHolder(itemView) {

        var newsItem: NewsResponse.News? = null

        private val imageView: ImageView? by lazy {
            itemView.findViewById(R.id.image) as ImageView?
        }

        private val titleView: TextView? by lazy {
            itemView.findViewById(R.id.title) as TextView?
        }

        private val authorView: TextView? by lazy {
            itemView.findViewById(R.id.author) as TextView?
        }

        private val descriptionView: TextView? by lazy {
            itemView.findViewById(R.id.description) as TextView?
        }


        fun bindView(newsItem: NewsResponse.News?) : Unit {
            this.newsItem = newsItem

            if (newsItem!!.title == null) {
                titleView!!.visibility = View.GONE
            } else {
                titleView!!.text = newsItem!!.title
            }

            if (newsItem!!.author == null) {
                authorView!!.visibility = View.GONE
            } else {
                authorView!!.text = newsItem!!.author
            }

            if (newsItem!!.description == null) {
                descriptionView!!.visibility = View.GONE
            } else {
                descriptionView!!.text = newsItem!!.description
            }

            if (newsItem!!.urlToImage == null) {
                imageView!!.visibility = View.GONE
            } else {
                Picasso.with(itemView.context)
                        .load(newsItem!!.urlToImage)
                        .fit()
                        .centerCrop()
                        .noFade()
                        .into(imageView)
            }

        }
    }
}
