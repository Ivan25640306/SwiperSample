package com.ivan.android.swipersample.data

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class DataRepository(private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO) {

    suspend fun getPageOneData(): CoinListData = withContext(ioDispatcher){
        delay(2500)
        val dataList:ArrayList<CoinInfo> = arrayListOf(
                CoinInfo("容幣", "XNC (無限錢包)", 9102619, 0.123, 1.849, 681.213, 1793.729),
                CoinInfo("容2幣", "CS (錢包)", 335219, 0.444, 3.849, 68.213, 17934.729),
                CoinInfo("山幣", "XC (無限錢包)", 42619, 0.999, 1.323, 61.213, 17493.729),
                CoinInfo("華幣", "X (無錢包)", 73619, 0.777, 4.231, 6.233, 1793.729),
                CoinInfo("火幣", "XNC (限錢包)", 3219, 0.888, 1.777, 677.213, 193.729),
                CoinInfo("比特幣", "XN (無限錢包)", 88619, 0.999, 9.849, 699.213, 1793.722),
                )


        val ad:ADInfo = ADInfo("2019 中臺灣元宵燈會-福滿迎豬，燈會限定，網美必拍 !!!","台中市政府")

        return@withContext CoinListData(dataList, ad)
    }

    suspend fun getPageTwoData(): CoinListData = withContext(ioDispatcher){

        delay(1500)
        val dataList:ArrayList<CoinInfo> = arrayListOf(
                CoinInfo("容幣", "XNC (無限錢包)", 9102619, 0.123, 1.849, 681.213, 1793.729),
                CoinInfo("山幣", "XC (無限錢包)", 42619, 0.999, 1.323, 61.213, 1793.729),
                CoinInfo("111幣", "XNC (限錢包)", 3219, 0.888, 1.777, 677.213, 1793.729),
                CoinInfo("比特幣", "XN (無限錢包)", 88619, 0.999, 9.849, 699.213, 1793.729),
        )


        val ad:ADInfo = ADInfo("2039 北臺灣元宵燈會-福滿迎豬，燈會限定，網美必拍 !!!","台北市政府")

        return@withContext CoinListData(dataList, ad)
    }
}