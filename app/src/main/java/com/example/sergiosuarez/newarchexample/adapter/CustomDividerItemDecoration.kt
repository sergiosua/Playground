package com.example.sergiosuarez.newarchexample.adapter

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.sergiosuarez.newarchexample.R

class CustomDividerItemDecoration(context: Context?) : RecyclerView.ItemDecoration() {

    val drawable: Drawable? = ContextCompat.getDrawable(context!!, R.drawable.divider_light_grey)
    private val padding: Int = context!!.resources.getDimensionPixelSize(R.dimen.default_padding)

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        val adapter = parent.adapter ?: return

        for (i in 0 until parent.childCount) {
            val child = parent.getChildAt(i)
            val position = parent.getChildAdapterPosition(child)

            //Avoid painting the divider in the last item
            if (position == adapter.itemCount - 1) {
                continue
            }

            drawable?.let {
                drawDivider(c, child, drawable)
            }
        }
    }

    private fun drawDivider(canvas: Canvas, item: View, drawable: Drawable) {
        val left = (item.left + item.translationX + padding).toInt()
        val top = (item.top + item.translationY).toInt()
        val right = item.width - padding
        val bottom = top + item.height

        drawable.setBounds(left, top + item.height - drawable.intrinsicHeight, right, bottom)
        drawable.alpha = (item.alpha * 255).toInt()
        drawable.draw(canvas)
    }

}