package com.plcoding.cryptocurrencyappyt.data.remote.dto.coin_detail_dto


import com.google.gson.annotations.SerializedName

data class TeamMember(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("position")
    val position: String
)