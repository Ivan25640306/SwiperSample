package com.ivan.android.swipersample.ui.wallet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayoutMediator
import com.ivan.android.swipersample.R
import kotlinx.android.synthetic.main.fragment_wallet.*

class WalletFragment: Fragment() {

    private val adpater by lazy { WalletPageAdapter(activity as AppCompatActivity) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_wallet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide
            .with(this)
            .load("https://event.12cm.com.tw/starbucks/img/siren-l.png")
            .error(R.drawable.icon_chat)
            .circleCrop()
            .into(iv_main_page_icon);

        vp_wallet_page_list.apply {
            offscreenPageLimit = 2
            adapter = this@WalletFragment.adpater
        }

        TabLayoutMediator(tl_coin_tab, vp_wallet_page_list) { tab, pos ->
            tab.text = when(pos) {
                0 -> getString(R.string.rongcoin_record)
                1 -> getString(R.string.voucher)
                else -> ""
            }

        }.attach()

    }
}