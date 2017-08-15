package com.application.library.kotlin.data.repository.news

import com.application.library.kotlin.data.api.model.NewsResponse

/**
 * Created by eminartiys on 8/15/17.
 */
class NewsRepository(var remoteDataSource: NewsDataSource) : NewsDataSource {

    override fun getNews(source: String, callback: NewsDataSource.LoadDataCallback) {
        remoteDataSource.getNews(source, object : NewsDataSource.LoadDataCallback {
            override fun onDataLoaded(newsResponse: NewsResponse) {
                callback.onDataLoaded(newsResponse)
            }

            override fun onError(throwable: Throwable) {
                callback.onError(throwable)
            }

        })
    }
}