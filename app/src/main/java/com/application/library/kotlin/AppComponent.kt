package com.application.library.kotlin

import com.application.library.kotlin.data.DataModule
import dagger.Component
import javax.inject.Singleton

@Component (
        modules = arrayOf(
                AppModule::class,
                NetworkModule::class,
                DataModule::class)
)

@Singleton
interface AppComponent : AppGraph {
}
