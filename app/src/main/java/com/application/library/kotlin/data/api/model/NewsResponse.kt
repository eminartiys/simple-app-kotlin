package com.application.library.kotlin.data.api.model

import android.support.v7.widget.DialogTitle

/**
 * Created by eminartiys on 8/14/17.
 */
class NewsResponse(val status: String, val code: String?, val message: String?,
                   val source: String?, val sortBy: String?,
                   val articles: List<News>?) {

    inner class News(val author: String, val title: String, val description: String,
                         val url: String, val urlToImage: String, val publishedAt: String)
}