package com.plcoding.cryptocurrencyappyt.presentaion.coin_details

import com.plcoding.cryptocurrencyappyt.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading:Boolean = false,
    val coinDetail: CoinDetail? = null,
    val error:String = ""
)