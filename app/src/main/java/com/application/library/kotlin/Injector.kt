package com.application.library.kotlin

import android.content.Context

/**
 * Created by eminartiys on 8/5/17.
 */
object Injector {

    fun obtain(context: Context): AppGraph? {
        return App.get(context).injector
    }

    internal fun create(app: App): AppGraph {
        return DaggerAppComponent.builder().appModule(AppModule(app)).build()
    }
}
