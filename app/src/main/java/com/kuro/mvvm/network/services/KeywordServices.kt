package com.kuro.mvvm.network.services

import com.kuro.mvvm.model.response.ResponseKeyword
import kotlinx.coroutines.Deferred
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Headers

interface KeywordServices{
    @GET("android-home-test/v2/keywords.json")
    fun getKeyWordsAsync() : Deferred<List<String>>

}