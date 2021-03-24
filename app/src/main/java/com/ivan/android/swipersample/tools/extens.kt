package com.ivan.android.swipersample.tools

import android.os.Bundle
import androidx.fragment.app.Fragment
import java.text.DecimalFormat

val intAddColonFormat = DecimalFormat(",###")
val doubleGetDecimalNumFormat = DecimalFormat(".###")
val doubleAddPlusAndColonFormat = DecimalFormat("+,###")

inline fun <T : Fragment> T.withBundleValue(argsBuilder: Bundle.() -> Unit):
        T = this.apply { arguments = Bundle().apply(argsBuilder) }


inline fun <reified T : Any> Fragment.getBundleValue(key: String, default: T) = lazy {
    arguments?.get(key) as? T ?: default
}

fun Int.addColon(): String {
    return intAddColonFormat.format(this)
}

fun Double.decimalNum(): String {
    val str = doubleGetDecimalNumFormat.format(this)
    val startIndex =str.indexOf(".")
    return str.substring(startIndex)
}

fun Double.addPlusAndColon(): String {
    return doubleAddPlusAndColonFormat.format(this)
}

