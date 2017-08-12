package com.application.library.kotlin.ui.source

import com.application.library.kotlin.data.api.model.SourceResponse
import com.application.library.kotlin.data.repository.source.SourceDataSource
import com.application.library.kotlin.data.repository.source.SourceRepository

/**
 * Created by eminartiys on 8/5/17.
 */
class SourcePresenter(private val view : SourceContract.View,
                      private val repository: SourceRepository)
    : SourceContract.Presenter {

    init {
        this.view.setPresenter(this)
    }


    override fun getData() {
        repository.getSource(object : SourceDataSource.LoadDataCallback {
            override fun onDataLoaded(sourceResponse: SourceResponse) {
                view.updateView(sourceResponse)
            }

            override fun onError(throwable: Throwable) {

            }

        })
    }

}

