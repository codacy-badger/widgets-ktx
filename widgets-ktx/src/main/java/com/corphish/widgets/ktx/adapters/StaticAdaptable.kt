package com.corphish.widgets.ktx.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Generic interface that allows definition of key RecyclerView adapter methods
 * This is done so that creating multiple adapters can be avoided
 * This is intended to be used with non-changing data only
 * While it is possible to work with changing data sets with variation
 * @param T Indicates the type of data, list of which shall be presented
 * @param V ViewHolder type
 *
 * This does not support multiple data sets so please combine your multiple data items into one single class
 */
abstract class StaticAdaptable<T, V: RecyclerView.ViewHolder> {
    /**
     * Layout resource for adapter view
     */
    abstract fun getLayoutResource(): Int

    /**
     * List that is to be adapted
     */
    abstract fun getListItems(): List<T>

    /**
     * ViewHolder for RV
     */
    abstract fun getViewHolder(view: View): V

    /**
     * onBind adapter method interface
     */
    abstract fun bind(viewHolder: V, item: T)

    /**
     * Finally builds the adapter
     */
    fun buildAdapter(notifyDataSetChange: Boolean = true): StaticAdapter<T, V> {
        val adapter = StaticAdapter(this)
        if (notifyDataSetChange) adapter.notifyDataSetChanged()

        return adapter
    }
}