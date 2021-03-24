package com.ivan.android.swipersample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.LabelVisibilityMode
import com.ivan.android.swipersample.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    val adapter: MainPageAdapter by lazy { MainPageAdapter(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {
        vp_page.apply {
            isUserInputEnabled = false
            offscreenPageLimit = this@MainActivity.adapter.itemCount
            adapter = this@MainActivity.adapter
        }

        bottom_nav_view_menu_bar.menu.apply {
            clear()
            add(0, R.id.main_phone,0, "PHONE").setIcon(R.drawable.phone)
            add(0, R.id.main_chat,1, "CHAT").setIcon(R.drawable.icon_chat)
            add(0, R.id.main_scanner,2, "SCANNER").setIcon(R.drawable.scanner)
            add(0, R.id.main_explore,3, "EXPLORE").setIcon(R.drawable.explore)
            add(0, R.id.main_wallet,4, "WALLET").setIcon(R.drawable.wallet)
        }

        bottom_nav_view_menu_bar.apply {
            labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_LABELED

            setOnNavigationItemSelectedListener { item ->
                vp_page.setCurrentItem(item.order, false)
                return@setOnNavigationItemSelectedListener true
            }
            selectedItemId = R.id.main_wallet
            vp_page.setCurrentItem(4, false)
        }
    }



}