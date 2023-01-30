package com.plcoding.cryptocurrencyappyt.domain.use_case.get_coins

import com.plcoding.cryptocurrencyappyt.common.Resource
import com.plcoding.cryptocurrencyappyt.data.remote.dto.toCoin
import com.plcoding.cryptocurrencyappyt.domain.model.Coin
import com.plcoding.cryptocurrencyappyt.domain.model.CoinDetail
import com.plcoding.cryptocurrencyappyt.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val coinRepository: CoinRepository) {

    operator fun invoke(): Flow<Resource<List<Coin>>> = flow{
        try {
            emit(Resource.Loading())
            val coins = coinRepository.getCoins().map { coinDto -> coinDto.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        }catch (e:HttpException){
            emit(Resource.Error<List<Coin>>(message = "Something went wrong while getting coins"))
        }catch (e: IOException){
            emit(Resource.Error<List<Coin>>(message = "Couldn't get coins, Check your internet connection"))
        }
    }

}