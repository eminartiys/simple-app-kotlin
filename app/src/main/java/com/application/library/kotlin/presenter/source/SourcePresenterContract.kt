package com.application.library.kotlin.presenter.source

import com.application.library.kotlin.ui.source.SourceViewContract

interface SourcePresenterContract {

    fun setView(view: SourceViewContract)

    fun cancelLoadSource()

    fun loadSource()
}