package com.kuro.mvvm.ui.hometest

import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kuro.mvvm.R
import com.kuro.mvvm.extension.getViewModel
import com.kuro.mvvm.model.entities.HotKeyword
import com.kuro.mvvm.ui.base.listener.BaseActivity
import com.kuro.mvvm.ui.hometest.adapter.HotKeywordAdapter
import com.kuro.mvvm.ui.hometest.viewholder.HotKeywordViewHolder
import kotlinx.android.synthetic.main.activity_home_test.*
import kotlinx.android.synthetic.main.item_rv_key_word.*
import java.lang.Math.abs

class HomeTestActivity : BaseActivity<HomeTestViewModel>() {

    companion object {
        const val SINGLE_WORD = 1
        const val DOUBLE_WORDS = 2
    }

    private val TAG = "HomeTestActivity"

    private lateinit var adapterRV: HotKeywordAdapter<HotKeyword>

    override fun getViewModel(): HomeTestViewModel = getViewModel<HomeTestViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        //This for splash screen
        setTheme(R.style.AppTheme_NoActionBar)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_test)
    }

    override fun initViews() {
        adapterRV = HotKeywordAdapter(
                R.layout.item_rv_key_word,
                HotKeywordViewHolder::class
        )

        rvKeyword.apply {
            adapter = adapterRV
            layoutManager = LinearLayoutManager(this@HomeTestActivity, LinearLayout.HORIZONTAL, false)
            addItemDecoration(object : RecyclerView.ItemDecoration() {
                override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                    super.getItemOffsets(outRect, view, parent, state)
                    outRect.left = resources.getDimension(R.dimen.small_margin).toInt()
                    outRect.right = resources.getDimension(R.dimen.small_margin).toInt()

                }
            })
        }

    }

    override fun observeData() {
        mViewModel.listKeyword.observe(this, Observer {
            Log.d(TAG, "List Data Received: $it")
            //convert data to View Holder better than convert on View Holder. This will save performance
            adapterRV.setData(it)
        })
    }

  /*  private fun convertListData(listData: ArrayList<HotKeyword>): ArrayList<HotKeyword> {
        val tempListData = ArrayList<HotKeyword>()
        for (i in 0 until listData.size) {
            val splitText = listData[i].text.split(" ")
            when (splitText.size) {
                SINGLE_WORD -> {
                    tempListData.add(listData[i])
                }
                DOUBLE_WORDS -> {
                    listData[i].text = splitText[0] + "\n" + splitText[1]
                    tempListData.add(listData[i])
                }
                else -> {
                    *//**
                     * This for case word with 3 words above
                     * First, get total length character on the string without space
                     * Second,
                     * Assume first words has length is a, and length other words will be [totalLengthCharacter] - a
                     * So the different between char will be abs(2*a - [totalLengthCharacter])
                     * Third, then now go find smallest different
                     *//*
                    val totalLengthCharacter = listData[i].text.replace(" ", "").length
                    var minimumDif = 2 * splitText[0].length - totalLengthCharacter
                    var tempMinimumDif = minimumDif
                    var posCutLine = splitText[0].length + 1 // This for position will be replace space to \n
                    var count = 0 // number of attempts words not meet requirement
                    for (i in 1 until splitText.size - 1) { // O(n-2)
                        if (abs(tempMinimumDif + 2 * splitText[i].length) <= abs(tempMinimumDif)) {
                            tempMinimumDif += 2 * splitText[i].length
                            if (abs(tempMinimumDif) <= abs(minimumDif)) {
                                minimumDif = tempMinimumDif
                                posCutLine += splitText[i].length + 1
                            }
                        } else {
                            tempMinimumDif += 2 * splitText[i].length
                            count++
                            *//**
                             *  Time by time, if the different keep increase then it will be always increase
                             *  So we stop there.
                             *//*
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
    }*/

}