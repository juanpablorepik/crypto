package com.example.crypto.data.Interface

import com.example.crypto.data.Models.CryptoModel

interface ICryptoRepository {

    suspend fun getCryptoList(currency : String): List<CryptoModel>?
}