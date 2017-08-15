package com.application.library.kotlin.data.repository.news

import com.application.library.kotlin.data.api.model.NewsResponse

/**
 * Created by eminartiys on 8/14/17.
 */
interface NewsDataSource {

    fun getNews(source: String, callback: LoadDataCallback)

    interface LoadDataCallback {
        fun onDataLoaded(newsResponse: NewsResponse)

        fun onError(throwable: Throwable)
    }
}