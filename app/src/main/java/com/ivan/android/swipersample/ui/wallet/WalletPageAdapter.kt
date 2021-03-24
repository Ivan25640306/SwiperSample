package com.ivan.android.swipersample.ui.wallet

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ivan.android.swipersample.tools.withBundleValue
import com.ivan.android.swipersample.ui.wallet.WalletPageFragment.Companion.ATTR_PAGE_INDEX

class WalletPageAdapter(fa: FragmentActivity): FragmentStateAdapter(fa) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
       return WalletPageFragment().withBundleValue {
           putInt(ATTR_PAGE_INDEX, position + 1)
       }
    }
}