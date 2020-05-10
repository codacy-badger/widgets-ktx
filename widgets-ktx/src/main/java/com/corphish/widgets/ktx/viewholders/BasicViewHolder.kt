package com.corphish.widgets.ktx.viewholders

import android.view.View
import androidx.annotation.IdRes
import androidx.annotation.Nullable

import androidx.recyclerview.widget.RecyclerView

/**
 * Implementations of view holders
 * The objective of this class is to minimise definition of viewholder classes
 * Apart from view on which this viewholder will be based
 * A list of view ids are also passed
 * This view ids will be used to map view ids to their views
 * Which can be later retrieved and used
 * @constructor
 * @param view Inflated view of item
 * @param viewList List of view ids present in view
 */
class BasicViewHolder(view: View, viewList: List<Int>) : RecyclerView.ViewHolder(view) {
    private val _views: MutableMap<Int, View> = HashMap()

    @Suppress("UNCHECKED_CAST")
    @Nullable
    fun <T : View?> getViewById(@IdRes id: Int): T? {
        return _views[id] as T
    }

    init {
        for (id in viewList) {
            _views[id] = view.findViewById(id)
        }
    }
}