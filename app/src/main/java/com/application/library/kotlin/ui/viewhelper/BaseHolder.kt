package com.application.library.kotlin.ui.viewhelper

import android.support.v7.widget.RecyclerView

/**
 * Created by eminartiys on 8/5/17.
 */
class BaseHolder<I>() : RecyclerView.ViewHolder {
}

//public class BaseViewHolder<I> extends RecyclerView.ViewHolder {
//
//    public BaseViewHolder(@LayoutRes int resId, @NonNull ViewGroup parent) {
//        super(LayoutInflater.from(parent.getContext()).inflate(resId, parent, false));
//    }
//
//    public void bindView(I object){}
//}