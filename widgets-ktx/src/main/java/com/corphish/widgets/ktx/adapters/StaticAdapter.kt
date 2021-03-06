package com.corphish.widgets.ktx.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Provides an adapter that can be used in recyclerview
 * It builds on an adaptable
 * @param T Type of data item
 * @param V RecyclerView ViewHolder
 * @property adaptable Adaptable from which the adapter will be built
 */
class StaticAdapter<T, V: RecyclerView.ViewHolder>(private val adaptable: StaticAdaptable<T, V>):
        RecyclerView.Adapter<V>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            adaptable.getViewHolder(LayoutInflater.from(parent.context).inflate(adaptable.getLayoutResource(), parent, false))

    override fun getItemCount() = adaptable.getListItems().size

    override fun onBindViewHolder(holder: V, position: Int) {
        adaptable.bind(holder, adaptable.getListItems()[position])
    }
}