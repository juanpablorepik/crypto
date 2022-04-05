package com.example.crypto.Data

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.crypto.Common.Constants
import com.example.crypto.Data.Interface.IApiInterface
import com.example.crypto.Data.Interface.ICryptoRepository
import com.example.crypto.Data.Models.CryptoModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CryptoImpl : ICryptoRepository{


    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()
    }

    override suspend fun getCryptoList(): List<CryptoModel>? {

        val call = getRetrofit().create(IApiInterface::class.java).getCrypto()
        if (call.isSuccessful)
        {Log.d(
            "LISTA","Llega")
            Log.d("LISTA",call.body()?.data.toString())
            return call.body()?.data
        }
        else
        {
            return emptyList()
        }
    }

}