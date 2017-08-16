package com.application.library.kotlin.ui.source

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.application.library.kotlin.R
import com.application.library.kotlin.data.api.model.SourceResponse
import kotlinx.android.synthetic.main.view_source_item.view.*

/**
 * Created by eminartiys on 8/11/17.
 */

class SourceAdapter : RecyclerView.Adapter<SourceAdapter.SourceViewHolder>() {

    private var items : List<SourceResponse.Sources>? = null

    private var clickListener : ItemClickListener? = null

    fun setClickListener(clickListener: ItemClickListener) {
        this.clickListener = clickListener
    }

    fun getClickListener() : ItemClickListener? {
        return clickListener
    }


    fun setItems(items: List<SourceResponse.Sources>) {
        this.items = items
        notifyItemRangeInserted(0, items.size)
    }

    fun clearItems() {
        val count = itemCount
        this.items = null
        notifyItemRangeRemoved(0, count)
    }

    override fun onBindViewHolder(holder: SourceViewHolder, position: Int) {
        holder.bindView(items!![position])

        holder.itemView.setOnClickListener {
            if (getClickListener() != null)
                getClickListener()!!.onItemClickListener(items!![position])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SourceViewHolder {
        return SourceViewHolder(LayoutInflater.from(
                        parent!!.context).inflate(R.layout.view_source_item, parent, false))
    }

    override fun getItemCount(): Int {
       return items?.size ?:0
    }

    class SourceViewHolder internal constructor (itemView : View)
        : RecyclerView.ViewHolder(itemView) {

        var sourceItem: SourceResponse.Sources? = null

        fun bindView(sourceItem: SourceResponse.Sources) : Unit {
            this.sourceItem = sourceItem

            if (sourceItem.name == null) {
                itemView.title.visibility = View.GONE
            } else {
                itemView.title.text = sourceItem.name
            }

            if (sourceItem.category == null) {
                itemView.category.visibility = View.GONE
            } else {
                itemView.category.text = sourceItem.category
            }

            if (sourceItem.description == null) {
                itemView.description.visibility = View.GONE
            } else {
                itemView.description.text = sourceItem.description
            }

        }
    }

    interface ItemClickListener {
        fun onItemClickListener(item: SourceResponse.Sources)
    }

}

