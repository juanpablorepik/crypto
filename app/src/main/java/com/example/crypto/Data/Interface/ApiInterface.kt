package com.example.crypto.Data.Interface

import com.example.crypto.Common.Constants
import com.example.crypto.Data.Models.ResponseModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {

    companion object {
        fun create(): ApiInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }

    @GET("v1/cryptocurrency/listings/latest?CMC_PRO_API_KEY=${Constants.CMC_PRO_API_KEY}&")
    fun getCrypto() : Call<ResponseModel>

}