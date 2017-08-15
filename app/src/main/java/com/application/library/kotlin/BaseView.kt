package com.application.library.kotlin

/**
 * Created by eminartiys on 8/4/17.
 */

interface BaseView<T> {

    fun setPresenter(presenter: T)
}