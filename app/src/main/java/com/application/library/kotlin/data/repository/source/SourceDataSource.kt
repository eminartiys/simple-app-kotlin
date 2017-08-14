package com.application.library.kotlin.data.repository.source

import com.application.library.kotlin.data.api.model.SourceResponse

/**
 * Created by eminartiys on 8/5/17.
 */

interface SourceDataSource {

    fun getSource(callback: LoadDataCallback)

    interface LoadDataCallback {
        fun onDataLoaded(sourceResponse: SourceResponse)

        fun onError(throwable: Throwable)
    }
}
