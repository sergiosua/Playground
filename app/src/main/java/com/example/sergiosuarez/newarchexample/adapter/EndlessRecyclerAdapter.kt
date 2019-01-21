package com.example.sergiosuarez.newarchexample.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.sergiosuarez.newarchexample.R
import com.example.sergiosuarez.newarchexample.extensions.inflate

abstract class EndlessRecyclerAdapter<T> : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val ITEM_TYPE = 0
        const val LOADING_TYPE = 1
    }

    var items: MutableList<T> = mutableListOf()
        set(value) {
            if (shouldClearData) {
                field.clear()
            }
            field.addAll(value)
            notifyDataSetChanged()
        }

    var isLoading: Boolean = false
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var shouldClearData = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == LOADING_TYPE) {
            LoadingViewHolder(parent.inflate(R.layout.layout_hero_loader))
        } else {
            createItemViewHolder(parent)
        }
    }

    override fun getItemCount(): Int = items.size + if (isLoading) 1 else 0

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        @Suppress("UNCHECKED_CAST")
        if (holder !is LoadingViewHolder) (holder as ItemViewHolder<T>).bind(items[position])
    }

    override fun getItemViewType(position: Int): Int {
        return if (isLoading && items.size == position) {
            LOADING_TYPE
        } else {
            ITEM_TYPE
        }
    }

    class LoadingViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    abstract fun createItemViewHolder(parent: ViewGroup): ItemViewHolder<T>

    abstract class ItemViewHolder<T>(val view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bind(item: T)
    }
}