package com.application.library.kotlin.data.repository.source

import com.application.library.kotlin.data.api.model.SourceResponse

/**
 * Created by eminartiys on 8/5/17.
 */

class SourceRepository (var remoteDataSource: RemoteSourceDataSource) : SourceDataSource {

    override fun getSource(callback: SourceDataSource.LoadDataCallback) {
        remoteDataSource.getSource(object : SourceDataSource.LoadDataCallback {
            override fun onDataLoaded(sourceResponse: SourceResponse) {
                callback.onDataLoaded(sourceResponse)
            }

            override fun onError(throwable: Throwable) {
                callback.onError(throwable)
            }

        })
    }
}