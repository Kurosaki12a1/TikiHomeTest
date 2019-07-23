package com.kuro.mvvm.ui.hometest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kuro.mvvm.model.entities.HotKeyword
import com.kuro.mvvm.ui.base.BaseAdapter
import com.kuro.mvvm.ui.base.BaseViewHolder
import kotlin.reflect.KClass
import kotlin.reflect.full.primaryConstructor

class HotKeywordAdapter<HotKeyword>(
        private val layoutId: Int,
        private val vhClass: KClass<out BaseViewHolder<HotKeyword>>
) : BaseAdapter<HotKeyword>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val constructor = vhClass.primaryConstructor
        return constructor!!.call(LayoutInflater.from(parent.context).inflate(layoutId, parent, false))
    }

}