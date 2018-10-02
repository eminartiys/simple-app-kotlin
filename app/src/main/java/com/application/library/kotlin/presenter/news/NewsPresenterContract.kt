package com.application.library.kotlin.presenter.news

import com.application.library.kotlin.ui.news.NewsViewContract

/**
 * Created by eminartiys on 8/15/17.
 */
interface NewsPresenterContract {

    fun setView(view: NewsViewContract)

    fun cancelLoadNews()

    fun loadNews(source: String)
}