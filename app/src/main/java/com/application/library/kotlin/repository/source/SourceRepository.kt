package com.application.library.kotlin.repository.source

import com.application.library.kotlin.model.SourceResponse
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by eminartiys on 8/5/17.
 */
class SourceRepository @Inject
    constructor(var remoteDataSource: RemoteSourceDataSource) : SourceDataSource {

    override fun getSource(): Single<SourceResponse> {
        return remoteDataSource.getSource()
    }
}