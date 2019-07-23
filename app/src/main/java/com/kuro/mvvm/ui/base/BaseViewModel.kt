package com.kuro.mvvm.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kuro.mvvm.utils.SingleLiveEvent
import kotlinx.coroutines.*

abstract class BaseViewModel : ViewModel(),BasicState {


    protected val viewModelJob = Job()
    protected val viewModelScope = CoroutineScope(Dispatchers.Default + viewModelJob)

    val globalState = SingleLiveEvent<GlobalState>()


    /**
     * Run a task in background
     * @return a Deferred to stop the task manually
     */

    protected fun async(call: suspend () -> Unit): Deferred<*> {
        return viewModelScope.async {
            runCatching {
                call()
            }.onFailure {
                it.printStackTrace()
                postError(it.message)
            }
        }
    }

    override fun postError(msg: String?) {
        globalState.postValue(GlobalState.ERROR.apply {
            message = msg ?: ""
        })
    }

    override fun showLoading() {
        globalState.postValue(GlobalState.SHOW_LOADING)
    }

    override fun hideLoading() {
        globalState.postValue(GlobalState.HIDE_LOADING)
    }
    override fun postNotiFollow(msg: String?) {
        globalState.postValue(GlobalState.NOTIFOLLOW.apply {
            message = msg ?: ""
        })
    }
    override fun postNotiFavo(msg: String?) {
        globalState.postValue(GlobalState.NOTIFAVO.apply {
            message = msg ?: ""
        })
    }
    override fun checkpackage(msg: String?) {
        globalState.postValue(GlobalState.CHECKPACKAGE.apply {
            message = msg ?: ""
        })
    }
}

enum class GlobalState {
    SHOW_LOADING,
    HIDE_LOADING,
    ERROR,
    NOTIFOLLOW,
    NOTIFAVO,
    CHECKPACKAGE;

    var message: String = ""
}

interface BasicState {

    /**
     *
     */
    fun postError(msg: String?)

    /**
     * Not sure if have to use this, since show loading make app feel slower
     */
    fun showLoading()

    /**
     *
     */
    fun hideLoading()

    fun postNotiFollow(msg: String?)

    fun postNotiFavo(msg: String?)

    fun checkpackage(msg: String?)
}
