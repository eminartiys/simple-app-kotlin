package com.application.library.kotlin

import com.application.library.kotlin.data.api.AutoValueAdapterFactory
import com.application.library.kotlin.data.api.NetworkConfig
import com.application.library.kotlin.data.api.service.SourceService
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by eminartiys on 8/4/17.
 */

@Module
class NetworkModule () {

    @Provides
    internal fun provideHttpLoggingInterceptor() : HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        }
        return loggingInterceptor
    }

    @Provides
    internal fun provideOkHttpClient(httpLoggingInterceptor
                                         : HttpLoggingInterceptor): OkHttpClient {
        val httpClientBuilder = OkHttpClient.Builder()
        httpClientBuilder.networkInterceptors().add(httpLoggingInterceptor)

        return httpClientBuilder.build()
    }

    @Provides
    internal fun provideGsonConverterFactory() : GsonConverterFactory {
        val GSON = GsonBuilder()
                .registerTypeAdapterFactory(AutoValueAdapterFactory())
                .create()
        return GsonConverterFactory.create(GSON)
    }

    @Provides
    internal fun provideRetrofit(okHttpClient: OkHttpClient,
                                 converterFactory: GsonConverterFactory) : Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://newsapi.org/v1/")
                .client(okHttpClient)
                .addConverterFactory(converterFactory)
                .build()
    }

    @Provides
    internal  fun provideSourceService(retrofit: Retrofit) : SourceService {
        return retrofit.create<SourceService>(SourceService::class.java)
    }
}
