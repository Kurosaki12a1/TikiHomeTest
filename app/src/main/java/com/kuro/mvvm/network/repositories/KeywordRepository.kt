package com.kuro.mvvm.network.repositories

import com.kuro.mvvm.model.response.ResponseKeyword
import com.kuro.mvvm.network.API
import okhttp3.ResponseBody

class KeywordRepository {
    companion object {
        val INSTANCE = KeywordRepository()
    }

    suspend fun getKeyword(): List<String> {
        return API.keywordServices.getKeyWordsAsync().await()
    }
}