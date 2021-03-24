package com.ivan.android.swipersample.data

interface IInfo

data class CoinListData(val data: ArrayList<CoinInfo>, val ad: ADInfo)

data class CoinInfo(val title: String, val subTitle: String, val count:Int, val value:Double,
                    val interactionRewards: Double, val socialRewards: Double, val revenue: Double):IInfo

data class ADInfo(val content: String, val unit: String): IInfo