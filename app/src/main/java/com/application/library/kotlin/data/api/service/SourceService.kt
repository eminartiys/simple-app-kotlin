package com.application.library.kotlin.data.api.service

import com.application.library.kotlin.model.SourceResponse
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by eminartiys on 8/5/17.
 */
interface SourceService {

    @GET("sources")
    fun getSources() : Single<SourceResponse>

}