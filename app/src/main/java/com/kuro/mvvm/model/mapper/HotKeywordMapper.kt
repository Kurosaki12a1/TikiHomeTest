package com.kuro.mvvm.model.mapper

import com.kuro.mvvm.model.entities.HotKeyword
import com.kuro.mvvm.ui.hometest.HomeTestActivity
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
        return convertListData(tempListHotKeyword)
    }

    private fun convertListData(listData: ArrayList<HotKeyword>): ArrayList<HotKeyword> {
        val tempListData = ArrayList<HotKeyword>()
        for (i in 0 until listData.size) {
            val splitText = listData[i].text.split(" ")
            when (splitText.size) {
                HomeTestActivity.SINGLE_WORD -> {
                    tempListData.add(listData[i])
                }
                HomeTestActivity.DOUBLE_WORDS -> {
                    listData[i].text = splitText[0] + "\n" + splitText[1]
                    tempListData.add(listData[i])
                }
                else -> {
                    /**
                     * This for case word with 3 words above
                     * First, get total length character on the string without space
                     * Second,
                     * Assume first words has length is a, and length other words will be [totalLengthCharacter] - a
                     * So the different between char will be abs(2*a - [totalLengthCharacter])
                     * Third, then now go find smallest different
                     */
                    val totalLengthCharacter = listData[i].text.replace(" ", "").length
                    var minimumDif = 2 * splitText[0].length - totalLengthCharacter
                    var tempMinimumDif = minimumDif
                    var posCutLine = splitText[0].length + 1 // This for position will be replace space to \n
                    var count = 0 // number of attempts words not meet requirement
                    for (i in 1 until splitText.size - 1) { // O(n-2)
                        if (Math.abs(tempMinimumDif + 2 * splitText[i].length) <= Math.abs(tempMinimumDif)) {
                            tempMinimumDif += 2 * splitText[i].length
                            if (Math.abs(tempMinimumDif) <= Math.abs(minimumDif)) {
                                minimumDif = tempMinimumDif
                                posCutLine += splitText[i].length + 1
                            }
                        } else {
                            tempMinimumDif += 2 * splitText[i].length
                            count++
                            /**
                             *  Time by time, if the different keep increase then it will be always increase
                             *  So we stop there.
                             */
                            if (count >= 2) {
                                break
                            }
                        }
                    }
                    listData[i].text = listData[i].text.substring(0, posCutLine - 1) + "\n" + listData[i].text.substring(posCutLine)
                    tempListData.add(listData[i])
                }
            }

        }
        return tempListData
    }
}



