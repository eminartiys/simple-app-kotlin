package com.application.library.kotlin.ui.source

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.application.library.kotlin.R
import com.application.library.kotlin.model.SourceResponse
import com.application.library.kotlin.widget.viewholder.SourceViewHolder

/**
 * Created by eminartiys on 8/11/17.
 */

class SourceAdapter : RecyclerView.Adapter<SourceViewHolder>() {

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SourceViewHolder {
        return SourceViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.view_source_item, parent, false))
    }

    override fun getItemCount(): Int {
       return items?.size ?:0
    }

    interface ItemClickListener {
        fun onItemClickListener(item: SourceResponse.Sources)
    }

}

