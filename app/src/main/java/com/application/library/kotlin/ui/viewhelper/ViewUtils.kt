@file:JvmName("ViewUtils")

package com.application.library.kotlin.ui.viewhelper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by eminartiys on 8/5/17.
 */
fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}