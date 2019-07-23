package com.kuro.mvvm.ui.hometest.viewholder

import android.graphics.Color
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import com.kuro.mvvm.R
import com.kuro.mvvm.model.entities.HotKeyword
import com.kuro.mvvm.ui.base.BaseViewHolder
import kotlinx.android.synthetic.main.item_rv_key_word.*

class HotKeywordViewHolder(itemView: View) : BaseViewHolder<HotKeyword>(itemView) {

    /**
     * [data] it's a data passed to ViewHolder through adapter
     */

    override fun initViews() {

    }

    override fun bind() {
        data?.let {
            tvKeyword.text = it.text
            layoutKeyword.setBackgroundResource(it.backGroundColor)
        }
    }

}