package com.application.library.kotlin.ui.viewhelper;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eminartiys on 8/2/17.
 */

public abstract class BaseViewAdapter<I> extends RecyclerView.Adapter<BaseViewHolder> {

    private List<Object> items = new ArrayList<>();

    private ItemClickListener itemClickListener;

    public ItemClickListener getItemClickListener() {
        return itemClickListener;
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public List<Object> getItems() {
        return items;
    }

    public Object getItem(int position) {
        return items.get(position);
    }

    public void clearData() {
        int count = getItemCount();
        this.items.clear();
        notifyItemRangeRemoved(0, count);
    }

    public void setItems(List<I> items) {
        this.items.addAll(items);
        notifyItemRangeInserted(0, items.size());
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return createHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        bindHolder(holder, position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public abstract BaseViewHolder<I> createHolder(ViewGroup parent, int viewType);

    public abstract void bindHolder(BaseViewHolder holder, int position);

    public interface ItemClickListener<I> {
        void onItemClickListener(I item);
    }
}
