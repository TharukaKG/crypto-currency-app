package com.plcoding.cryptocurrencyappyt.domain.use_case.get_coin

import com.plcoding.cryptocurrencyappyt.common.Resource
import com.plcoding.cryptocurrencyappyt.data.remote.dto.coin_detail_dto.toCoinDetail
import com.plcoding.cryptocurrencyappyt.data.remote.dto.toCoin
import com.plcoding.cryptocurrencyappyt.domain.model.Coin
import com.plcoding.cryptocurrencyappyt.domain.model.CoinDetail
import com.plcoding.cryptocurrencyappyt.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinDetailUseCase @Inject constructor(private val coinRepository: CoinRepository) {

    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow{
        try {
            emit(Resource.Loading())
            val coinDetail = coinRepository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coinDetail))
        }catch (e:HttpException){
            emit(Resource.Error<CoinDetail>(message = "Something went wrong while getting coin details"))
        }catch (e: IOException){
            emit(Resource.Error<CoinDetail>(message = "Couldn't get coin details, Check your internet connection"))
        }
    }

}