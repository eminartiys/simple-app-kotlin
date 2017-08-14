package com.application.library.kotlin

import com.application.library.kotlin.data.DataModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by eminartiys on 8/4/17.
 */

@Component (
        modules = arrayOf(
                AppModule::class,
                NetworkModule::class,
                DataModule::class)
)

@Singleton
interface AppComponent : AppGraph {
}
