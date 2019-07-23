package com.kuro.mvvm.ui.hometest

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kuro.mvvm.model.entities.HotKeyword
import com.kuro.mvvm.model.mapper.HotKeywordMapper
import com.kuro.mvvm.model.response.ResponseKeyword
import com.kuro.mvvm.network.repositories.KeywordRepository
import com.kuro.mvvm.ui.base.BaseViewModel
import okhttp3.ResponseBody

class HomeTestViewModel : BaseViewModel() {
    private val _repository by lazy { KeywordRepository.INSTANCE }
    private val _listKeyword = MutableLiveData<ArrayList<HotKeyword>>()
    val listKeyword: LiveData<ArrayList<HotKeyword>>
        get() = _listKeyword

    init {
        getListKeyword()
    }

    private fun getListKeyword() {
        async {
            val response = _repository.getKeyword()
            _listKeyword.postValue(HotKeywordMapper().convertToListHotKeyWord(ArrayList(response)))
        }
    }
}