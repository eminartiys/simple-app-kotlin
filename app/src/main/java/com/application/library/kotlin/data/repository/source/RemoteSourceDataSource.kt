package com.application.library.kotlin.data.repository.source

import com.application.library.kotlin.data.api.model.SourceResponse
import com.application.library.kotlin.data.api.service.SourceService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by eminartiys on 8/5/17.
 */
class RemoteSourceDataSource(var sourceService: SourceService) : SourceDataSource {

    override fun getSource(callback: SourceDataSource.LoadDataCallback) {
        sourceService.getSources().enqueue(object : Callback<SourceResponse> {
            override fun onResponse(call: Call<SourceResponse>,
                                    response: Response<SourceResponse>) {
                callback.onDataLoaded(response.body()!!)
            }

            override fun onFailure(call: Call<SourceResponse>, t: Throwable) {
                callback.onError(t)
            }

        })
    }
}
