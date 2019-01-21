package com.example.sergiosuarez.newarchexample.adapter

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

interface OnLimitReachedListener {
    fun onPageLimitReachedListener()
}

class EndlessRecyclerListener(
    private val listener: OnLimitReachedListener,
    var isLoading: Boolean = false
) : RecyclerView.OnScrollListener() {

    companion object {
        private const val PAGE_SIZE = 20
        const val limit = PAGE_SIZE / 3
    }

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        var linearLayoutManager = recyclerView.layoutManager as LinearLayoutManager

        val totalItems = linearLayoutManager.itemCount
        val firstItem = linearLayoutManager.findFirstVisibleItemPosition()
        val visibleItems = linearLayoutManager.childCount

        val limitItems = totalItems - limit
        val actualMaxItem = firstItem + visibleItems

        if (!isLoading && totalItems != 0 && limitItems <= actualMaxItem) {
            listener.onPageLimitReachedListener()
        }
    }
}