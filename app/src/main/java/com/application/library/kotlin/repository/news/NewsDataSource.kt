package com.application.library.kotlin.repository.news

import com.application.library.kotlin.model.NewsResponse
import io.reactivex.Single

/**
 * Created by eminartiys on 8/14/17.
 */
interface NewsDataSource {

    fun getNews(source: String): Single<NewsResponse>
}