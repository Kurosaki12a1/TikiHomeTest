package com.kuro.mvvm.ui.base.listener

/**
 * Basic interface of ViewHolder, easy to use and understand, just set and bind.
 */
interface ViewHolder<TYPE> {
    /**
     * Data is data, no need to explain
     */
    var data: TYPE?

    /**
     * Method call in [BaseAdapter] to set data for ViewHolder
     */
    fun set(data: TYPE)

    /**
     * Method call in [BaseAdapter] to start binding data for ViewHolder
     */
    fun bind()
}