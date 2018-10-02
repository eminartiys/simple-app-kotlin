package com.application.library.kotlin.ui.news

import com.application.library.kotlin.model.NewsResponse

/**
 * Created by eminartiys on 8/15/17.
 */
interface NewsViewContract {

    fun showNews(list: NewsResponse)

    fun handleError()

    fun getCurrentSource(): String
}