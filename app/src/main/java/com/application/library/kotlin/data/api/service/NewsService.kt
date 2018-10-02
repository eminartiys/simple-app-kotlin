package com.application.library.kotlin.data.api.service

import com.application.library.kotlin.model.NewsResponse
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by eminartiys on 8/15/17.
 */
interface NewsService {

    @GET("articles")
    fun getNews(@Query("source") source: String,
                @Query("apiKey") apiKey: String) : Single<NewsResponse>
}