package com.application.library.kotlin.repository.source

import com.application.library.kotlin.model.SourceResponse
import io.reactivex.Single

/**
 * Created by eminartiys on 8/5/17.
 */
interface SourceDataSource {

    fun getSource(): Single<SourceResponse>
}
