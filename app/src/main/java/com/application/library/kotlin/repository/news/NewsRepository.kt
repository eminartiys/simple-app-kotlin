package com.application.library.kotlin.repository.news

import com.application.library.kotlin.model.NewsResponse
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by eminartiys on 8/15/17.
 */
class NewsRepository @Inject
    constructor(var remoteDataSource: NewsDataSource) : NewsDataSource {
    override fun getNews(source: String): Single<NewsResponse> {

        return remoteDataSource.getNews(source)
    }
}