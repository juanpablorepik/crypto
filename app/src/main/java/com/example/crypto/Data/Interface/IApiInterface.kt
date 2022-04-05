package com.example.crypto.Data.Interface

import com.example.crypto.Common.Constants
import com.example.crypto.Data.Models.ResponseModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface IApiInterface {

    @GET("v1/cryptocurrency/listings/latest?CMC_PRO_API_KEY=${Constants.CMC_PRO_API_KEY}&limit=20")
    suspend fun getCrypto() : Response<ResponseModel>

}