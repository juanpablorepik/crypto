package com.example.crypto.Data.Interface

import com.example.crypto.Data.Models.CryptoModel
import retrofit2.Response

interface ICryptoRepository {

    suspend fun getCryptoList(): List<CryptoModel>?
}