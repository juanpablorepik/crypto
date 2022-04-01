package com.example.crypto.Data.Models

import com.google.gson.annotations.SerializedName

data class ResponseModel (@SerializedName("data") val data : List<CryptoModel>)
