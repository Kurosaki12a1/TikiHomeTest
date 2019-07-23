package com.kuro.mvvm.ui.base.listener

import com.kuro.mvvm.ui.base.BaseViewModel

interface BaseView<VM : BaseViewModel> {

    /**
     * Return ViewModel
     */
   fun getViewModel(): VM

    /**
     * Init and set views event like onClick, onTextChanged ...
     */
    fun initViews()

    /**
     * Observe ViewModel data if have to
     */
    fun observeData()

    /**
     * Observe ViewModel globalState to handle common error
     */
    fun observeState() {}
}