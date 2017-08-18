package com.application.library.kotlin

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by eminartiys on 8/4/17.
 */
@Module
class AppModule (val application : App) {

    @Provides
    fun provideApp() = application

    @Provides
    fun provideContext() = application
}
