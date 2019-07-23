package com.kuro.mvvm.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.kuro.mvvm.network.services.KeywordServices
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

object API {

    private val gson: Gson = GsonBuilder()
            .disableHtmlEscaping()
            .create()

    private const val URL_REQUEST = "https://raw.githubusercontent.com/tikivn/"

    private val client = getClient(URL_REQUEST)


    private fun getClient(url: String): Retrofit {
        return Retrofit.Builder()
                .baseUrl(url)
                .client(OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()

    }

    private val clientInterceptor = Interceptor { chain ->
        val request = chain.request()
                .newBuilder()
                .url(chain.request().url())
                .addHeader("sample-header", "sample-header-value")
                .build()
        return@Interceptor chain.proceed(request)
    }

    val keywordServices = client.create(KeywordServices::class.java) as KeywordServices

}