package com.application.library.kotlin.data.repository.news

import com.application.library.kotlin.data.api.model.NewsResponse
import com.application.library.kotlin.data.api.service.NewsService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by eminartiys on 8/15/17.
 */
class RemoteNewsDataSource(var newsService: NewsService) : NewsDataSource {

    val API_KEY = "a67c7cdaf80644908b3df94747642471"

    override fun getNews(source: String, callback: NewsDataSource.LoadDataCallback) {
        newsService.getNews(source, API_KEY).enqueue(object : Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                when {
                    response.isSuccessful   -> callback.onDataLoaded(response.body()!!)
                    else                    -> callback.onError(Throwable())
                }
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                callback.onError(t)
            }

        })
    }

}