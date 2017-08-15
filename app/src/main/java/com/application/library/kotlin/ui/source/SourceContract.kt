package com.application.library.kotlin.ui.source

import com.application.library.kotlin.BasePresenter
import com.application.library.kotlin.data.api.model.SourceResponse
import com.application.library.kotlin.BaseView

/**
 * Created by eminartiys on 8/4/17.
 */

interface SourceContract {

    interface View : BaseView<Presenter> {

        fun updateView(list : SourceResponse)
    }
    interface Presenter : BasePresenter {

        fun getData()
    }
}