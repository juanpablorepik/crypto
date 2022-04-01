package com.example.crypto.Data.Models

import com.google.gson.annotations.SerializedName

data class QuoteModel (@SerializedName("USD" ) var USD : USDModel? = USDModel(), @SerializedName("ARS" ) var ARS : ARSModel? = ARSModel())