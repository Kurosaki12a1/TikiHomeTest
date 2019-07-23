package com.kuro.mvvm.extension

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

/**
 * Get ViewModel from Activity
 */
inline fun <reified VM : ViewModel> FragmentActivity.getViewModel(vmFactory: ViewModelProvider.Factory? = null): VM {
    return ViewModelProviders.of(this, vmFactory).get(VM::class.java)
}

/**
 * Get ViewModel from Activity with key
 */
inline fun <reified VM : ViewModel> FragmentActivity.getViewModel(key: String, vmFactory: ViewModelProvider.Factory? = null): VM {
    return ViewModelProviders.of(this, vmFactory).get(key, VM::class.java)
}

/**
 * Get ViewModel from Activity
 */
internal fun <VM : ViewModel> FragmentActivity.getViewModel(vmClass: Class<VM>, vmFactory: ViewModelProvider.Factory? = null): VM {
    return vmFactory?.let { ViewModelProviders.of(this, it).get(vmClass) } ?: ViewModelProviders.of(this).get(vmClass)
}

/**
 * Toast message in Activity
 */
internal fun Activity.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

internal fun Activity.toast(message: Int) {
    toast(getString(message))
}