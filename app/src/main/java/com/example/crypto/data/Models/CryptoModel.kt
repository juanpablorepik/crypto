package com.example.crypto.data.Models

data class CryptoModel(val id : String, val name : String, val symbol : String , val quote : Map<String,PriceModel>)