package com.application.library.kotlin.data

import com.application.library.kotlin.data.api.service.SourceService
import com.application.library.kotlin.data.repository.source.RemoteSourceDataSource
import com.application.library.kotlin.data.repository.source.SourceRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by eminartiys on 8/5/17.
 */
@Module
class DataModule() {
    @Provides
    @Singleton
    internal fun provideRemoteSourceDataSource(sourceService :
                                               SourceService): RemoteSourceDataSource {
        return RemoteSourceDataSource(sourceService)
    }

    @Provides
    @Singleton
    internal fun provideSourceRepository(remoteSourceDataSource :
                                             RemoteSourceDataSource): SourceRepository {
        return SourceRepository(remoteSourceDataSource)
    }
}