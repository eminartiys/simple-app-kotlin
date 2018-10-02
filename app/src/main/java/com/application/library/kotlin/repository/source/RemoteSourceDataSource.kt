package com.application.library.kotlin.repository.source

import com.application.library.kotlin.data.api.service.SourceService
import com.application.library.kotlin.model.SourceResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by eminartiys on 8/5/17.
 */
class RemoteSourceDataSource @Inject
    constructor(var sourceService: SourceService) : SourceDataSource {

    override fun getSource(): Single<SourceResponse> {
        return sourceService.getSources()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
    }
}
