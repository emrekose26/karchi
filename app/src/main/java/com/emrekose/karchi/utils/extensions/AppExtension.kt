package com.emrekose.karchi.utils.extensions

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import com.emrekose.karchi.BuildConfig

/**
 * Created by emrekose on 13.12.2017.
 */

fun debug(block: () -> Unit) {
    if (BuildConfig.DEBUG) block()
}

inline fun FragmentManager.transact(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().func().commit()
}