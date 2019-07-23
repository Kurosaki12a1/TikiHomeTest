package com.kuro.mvvm.model.mapper

import com.kuro.mvvm.model.entities.HotKeyword
import com.kuro.mvvm.utils.RandomColor

class HotKeywordMapper {
    private val _randomColor by lazy { RandomColor.INSTANCE }

    private fun String.toHotKeyword(): HotKeyword {
        return HotKeyword(text = this,
                backGroundColor = _randomColor.getRandomColor())
    }

    fun convertToListHotKeyWord(listText : ArrayList<String>) : ArrayList<HotKeyword>{
        val tempListHotKeyword = ArrayList<HotKeyword>()
        for(i in 0 until listText.size){
            tempListHotKeyword.add(listText[i].toHotKeyword())
        }
        return tempListHotKeyword
    }
}



