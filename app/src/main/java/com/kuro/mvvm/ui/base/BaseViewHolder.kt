package com.kuro.mvvm.ui.base

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.kuro.mvvm.ui.base.listener.ViewHolder
import kotlinx.android.extensions.LayoutContainer

abstract class BaseViewHolder<TYPE>(itemView: View) :
        RecyclerView.ViewHolder(itemView), ViewHolder<TYPE>, LayoutContainer {

    override var data: TYPE? = null

    override val containerView: View?
        get() = itemView

    init {
        this.initViews()
    }

    /**
     * Init views config and event like onClick ...
     */
    abstract fun initViews()

    /**
     * To make sure the ViewHolder have data to show and return
     */
    override fun set(data: TYPE) {
        this.data = data
    }


}
