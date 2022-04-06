package com.example.crypto.data

import android.util.Log
import com.example.crypto.common.Constants
import com.example.crypto.data.Interface.IApiInterface
import com.example.crypto.data.Interface.ICryptoRepository
import com.example.crypto.data.Models.CryptoModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CryptoImpl : ICryptoRepository{


    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()
    }

    override suspend fun getCryptoList(currency : String): List<CryptoModel>? {
        Log.d("LISTA",currency)

        val call = getRetrofit().create(IApiInterface::class.java).getCrypto(Constants.CMC_PRO_API_KEY,currency,Constants.LIMIT)

        if (call.isSuccessful)
        {
            Log.d("LISTA",call.body()?.data.toString())
            return call.body()?.data?.toList()
        }
        else
        {
            Log.d("LISTA",call.isSuccessful.toString())
            return emptyList()
        }
    }

}