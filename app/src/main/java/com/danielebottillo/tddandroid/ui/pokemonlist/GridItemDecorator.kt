package com.danielebottillo.tddandroid.ui.pokemonlist

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

class GridItemDecorator(private val space: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View,
                                parent: RecyclerView, state: RecyclerView.State?) {
        outRect.left = space / 2
        outRect.right = space / 2
        outRect.bottom = space / 2

        // Add top margin only for the first item to avoid double space between items
        if (parent.getChildLayoutPosition(view) <=2) {
            outRect.top = space
        } else {
            outRect.top = 0
        }
    }
}