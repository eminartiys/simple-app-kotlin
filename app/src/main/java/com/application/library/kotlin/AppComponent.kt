package com.application.library.kotlin

import dagger.Component
import javax.inject.Singleton

@Component (
        modules = arrayOf(AppModule::class, NetworkModule::class)
)

@Singleton
interface AppComponent : AppGraph {
}
