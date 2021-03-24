package com.ivan.android.swipersample.ui.wallet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ivan.android.swipersample.R
import com.ivan.android.swipersample.data.ADInfo
import com.ivan.android.swipersample.data.CoinInfo
import com.ivan.android.swipersample.data.CoinListData
import com.ivan.android.swipersample.data.IInfo
import com.ivan.android.swipersample.tools.*
import kotlinx.android.synthetic.main.fragment_wallet.*
import kotlinx.android.synthetic.main.view_item_coin_record.view.*
import kotlinx.android.synthetic.main.view_item_wallet_ad.view.*

class WalletListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        val RES_COIN_DATA:Int = R.layout.view_item_coin_record
        val RES_AD: Int = R.layout.view_item_wallet_ad
    }

    private  val dataList: ArrayList<IInfo> = arrayListOf()


    override fun getItemViewType(position: Int): Int {
        return if(dataList[position] is CoinInfo) {
            RES_COIN_DATA
        } else {
            RES_AD
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = createViewById(parent, viewType)

        return when(viewType) {
            RES_COIN_DATA -> CoinDataViewHolder(view)
            else -> AdViewHolder(view)
        }
    }

    private fun createViewById(parent: ViewGroup, layoutRes: Int): View {
        return LayoutInflater.from(parent.context)
                .inflate(layoutRes, parent, false)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is CoinDataViewHolder) {
            holder.updateView(dataList[position] as CoinInfo?)
        }

        if (holder is AdViewHolder) {
            holder.updateView(dataList[position] as ADInfo?)
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun setCoinListData(coinListData: CoinListData) {
        dataList.clear()
        dataList.addAll(coinListData.data)
        dataList.add(coinListData.ad)
        notifyDataSetChanged()
    }

    inner class CoinDataViewHolder(view: View):RecyclerView.ViewHolder(view) {
        fun updateView(data: CoinInfo?) {
            data?.let {
                itemView.tv_title.text = it.title
                itemView.tv_subtitle.text = it.subTitle
                itemView.tv_coin_money.text = it.count.addColon()
                itemView.tv_coin_num.text = it.value.decimalNum()
                itemView.tv_ir_int.text = it.interactionRewards.addPlusAndColon()
                itemView.tv_ir_decimal.text = it.interactionRewards.decimalNum()
                itemView.tv_sr_int.text = it.socialRewards.addPlusAndColon()
                itemView.tv_sr_decimal.text = it.socialRewards.decimalNum()
                itemView.tv_revenue_int.text = it.revenue.addPlusAndColon()
                itemView.tv_revenue_decimal.text = it.revenue.decimalNum()

            } ?: kotlin.run {
                // do something
            }

        }
    }

    inner class AdViewHolder(view: View):RecyclerView.ViewHolder(view) {
        fun updateView(ad: ADInfo?) {
            ad?.let {
                itemView.tv_ad_context.text = it.content
                itemView.tv_ad_unit.text = it.unit


                Glide
                    .with(itemView)
                    .load("https://event.12cm.com.tw/starbucks/img/siren-l.png")
                    .error(R.drawable.icon_chat)
                    .circleCrop()
                    .into(itemView.iv_icon_ad);
            } ?: kotlin.run {
                // do something
            }
        }
    }
}