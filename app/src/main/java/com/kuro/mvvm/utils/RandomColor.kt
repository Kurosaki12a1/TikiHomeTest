package com.kuro.mvvm.utils

import com.kuro.mvvm.R
import java.util.*

class RandomColor {
    companion object {
        val INSTANCE = RandomColor()
        val listColor: MutableList<Int> = Arrays.asList(R.drawable.layout_item_keyword_ancient,
                R.drawable.layout_item_keyword_blue,
                R.drawable.layout_item_keyword_gray,
                R.drawable.layout_item_keyword_green,
                R.drawable.layout_item_keyword_orange,
                R.drawable.layout_item_keyword_purple,
                R.drawable.layout_item_keyword_red,
                R.drawable.layout_item_keyword_yellow,
                R.drawable.layout_tem_keyword_cyan
        )
    }
    fun getRandomColor() : Int {
        val random = Random().nextInt(listColor.size)
        return listColor[random]
    }
}


