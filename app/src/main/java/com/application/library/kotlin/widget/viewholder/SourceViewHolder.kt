package com.application.library.kotlin.widget.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.application.library.kotlin.model.SourceResponse
import kotlinx.android.synthetic.main.view_source_item.view.*


class SourceViewHolder internal constructor (itemView : View) : RecyclerView.ViewHolder(itemView) {

    var sourceItem: SourceResponse.Sources? = null

    fun bindView(sourceItem: SourceResponse.Sources) : Unit {
        this.sourceItem = sourceItem

        itemView.title.text = sourceItem.name
        itemView.category.text = sourceItem.category

        sourceItem.description?.let { itemView.description.text = sourceItem.description }

    }
}