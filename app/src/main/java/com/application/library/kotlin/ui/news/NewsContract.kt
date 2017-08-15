package com.application.library.kotlin.ui.news

import com.application.library.kotlin.BasePresenter
import com.application.library.kotlin.data.api.model.NewsResponse
import com.application.library.kotlin.BaseView

/**
 * Created by eminartiys on 8/15/17.
 */
interface NewsContract {

    interface View : BaseView<Presenter> {

        fun updateView(list: NewsResponse)

        fun handleError()

        fun getCurrentSource(): String
    }
    interface Presenter : BasePresenter {

        fun getData(source: String)
    }
}