package com.ivan.android.swipersample.ui

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ivan.android.swipersample.tools.*
import com.ivan.android.swipersample.ui.empty.SampleTextFragment
import com.ivan.android.swipersample.ui.empty.SampleTextFragment.Companion.ATTR_TEXT
import com.ivan.android.swipersample.ui.wallet.WalletFragment

class MainPageAdapter(fa: FragmentActivity): FragmentStateAdapter(fa) {

    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
             4 -> WalletFragment()

            else -> SampleTextFragment().withBundleValue {
                    putInt(ATTR_TEXT, position )
                }

        }
    }
}