package com.example.crypto.data.Models

import com.google.gson.annotations.SerializedName

data class ResponseModel (@SerializedName("data") val data : List<CryptoModel>)
