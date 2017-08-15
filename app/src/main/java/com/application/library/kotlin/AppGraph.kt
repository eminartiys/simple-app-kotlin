package com.application.library.kotlin

import com.application.library.kotlin.ui.news.NewsActivity
import com.application.library.kotlin.ui.source.SourceActivity

/**
 * Created by eminartiys on 8/5/17.
 */

interface AppGraph {

    fun inject(app: App)

    fun inject(sourceActivity: SourceActivity)

    fun inject(newsActivity: NewsActivity)
}