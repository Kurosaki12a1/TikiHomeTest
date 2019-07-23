package com.kuro.mvvm.ui.base.listener

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.kuro.mvvm.R
import com.kuro.mvvm.extension.getViewModel
import com.kuro.mvvm.ui.base.BaseViewModel
import com.kuro.mvvm.ui.hometest.HomeTestViewModel

/**
 * Base Activity
 */

abstract class BaseActivity<VM : BaseViewModel> : AppCompatActivity(), BaseView<VM> {

    protected lateinit var mViewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        mViewModel = getViewModel()
        super.onCreate(savedInstanceState)
    }

    /**
     * Since activity always use setContentView,
     * [initViews] and [observeData] will put after the super method to make sure
     * those views are available to use
     */
    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
        initViews()
        observeData()
    }

}