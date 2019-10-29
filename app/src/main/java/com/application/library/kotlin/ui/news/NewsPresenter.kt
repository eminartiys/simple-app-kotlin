package com.application.library.kotlin.ui.news

import com.application.library.kotlin.data.api.model.NewsResponse
import com.application.library.kotlin.data.repository.news.NewsDataSource
import com.application.library.kotlin.data.repository.news.NewsRepository

/**
 * Created by eminartiys on 8/15/17.
 */
class NewsPresenter(val view: NewsContract.View,
                    val repository: NewsRepository) : NewsContract.Presenter {

    init {
        this.view.setPresenter(this)
    }

    override fun start() {
        getData(view.getCurrentSource())
    }

    override fun getData(source: String) {
        repository.getNews(source, object : NewsDataSource.LoadDataCallback {
            override fun onDataLoaded(newsResponse: NewsResponse) {
                view.updateView(newsResponse)
            }

            override fun onError(throwable: Throwable) {
                view.handleError()
            }

        })
    }

}