package com.application.library.kotlin

import android.app.Application
import android.content.Context

/**
 * Created by eminartiys on 8/4/17.
 */

class App : Application() {

    internal var injector: AppGraph? = null
        private set

    override fun onCreate() {
        super.onCreate()

        // Dagger
        injector = Injector.create(this)
        injector!!.inject(this)

    }

    companion object {

        operator fun get(context: Context): App {
            return context.applicationContext as App
        }
    }
}