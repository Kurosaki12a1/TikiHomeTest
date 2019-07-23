package com.kuro.mvvm.ui.base

import android.system.Os.bind
import androidx.recyclerview.widget.RecyclerView
import com.kuro.mvvm.ui.base.listener.RVAdapter
import com.kuro.mvvm.ui.base.listener.ViewHolder

abstract class BaseAdapter<TYPE>: RecyclerView.Adapter<RecyclerView.ViewHolder>(),RVAdapter<TYPE>{
    override var listData: ArrayList<TYPE> = ArrayList()
    /**
     * Override this if want to make infinite list
     * @return the number of item in RecyclerView
     */
    override fun getItemCount(): Int {
        return listData.size
    }

    /**
     * Override this if want to make infinite list
     * @param position the position of item in RecyclerView
     * @return the object of item
     */
    protected fun getItem(position: Int): TYPE {
        return listData[position]
    }

    /**
     * Auto transfer data to [BaseViewHolder.bind]
     */
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder<*>) {
            (holder as ViewHolder<TYPE>).apply {
                set(listData[position])
                bind()
            }
        }
    }

    override fun setData(data: List<TYPE>) {
        listData.clear()
        listData.addAll(data)
        notifyDataSetChanged()
    }

}