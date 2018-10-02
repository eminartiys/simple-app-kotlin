package com.application.library.kotlin.repository.news

import com.application.library.kotlin.data.api.service.NewsService
import com.application.library.kotlin.model.NewsResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by eminartiys on 8/15/17.
 */
class RemoteNewsDataSource @Inject
    constructor(var newsService: NewsService): NewsDataSource {

    val API_KEY = "a67c7cdaf80644908b3df94747642471"

    override fun getNews(source: String): Single<NewsResponse> {
        return newsService.getNews(source, API_KEY)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
    }
}