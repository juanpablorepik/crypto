package com.example.crypto.data.Interface

import com.example.crypto.data.Models.ResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IApiInterface {

    @GET("v1/cryptocurrency/listings/latest")
    suspend fun getCrypto(@Query("CMC_PRO_API_KEY")key :String,@Query("convert") currency : String,@Query("limit")limit :String) : Response<ResponseModel>

}