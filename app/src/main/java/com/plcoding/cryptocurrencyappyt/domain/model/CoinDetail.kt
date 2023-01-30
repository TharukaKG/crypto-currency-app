package com.plcoding.cryptocurrencyappyt.domain.model

import com.plcoding.cryptocurrencyappyt.data.remote.dto.coin_detail_dto.TeamMember

data class CoinDetail(
    val coinId:String,
    val coinName:String,
    val description:String,
    val symbol:String,
    val rank:Int,
    val isActive:Boolean,
    val tags:List<String>,
    val team:List<TeamMember>
)
