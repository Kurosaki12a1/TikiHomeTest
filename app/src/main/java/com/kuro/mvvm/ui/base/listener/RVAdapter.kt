package com.kuro.mvvm.ui.base.listener

interface RVAdapter<TYPE> {
    /**
     * Data of Adapter, always a list
     */
    var listData: ArrayList<TYPE>

    /**
     * Set data for [RVAdapter]
     * Have to handle the data manually
     */
    fun setData(data: List<TYPE>)

    fun isEmpty(): Boolean {
        return listData.size == 0
    }

    /**
     * Get data base on position (for a list)
     */
    fun getData(pos: Int): TYPE {
        return listData[pos]
    }

}

