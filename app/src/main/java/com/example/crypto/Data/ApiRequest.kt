package com.example.crypto.Data

import android.util.Log
import com.example.crypto.Data.Interface.ApiInterface
import com.example.crypto.Data.Models.CryptoModel
import com.example.crypto.Data.Models.ResponseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiRequest (){


    companion object{
        val data : MutableList<CryptoModel> = ArrayList()

        fun requestApi() {
            Thread(Runnable {
                val apiInterface = ApiInterface.create().getCrypto()

                apiInterface.enqueue( object : Callback<ResponseModel> {
                    override fun onResponse(call: Call<ResponseModel>?, response: Response<ResponseModel>?) {

                        if(response?.body() != null)    {
                            Log.d("ApiResponse",response.body().toString())
                            data.addAll(response.body()!!.data)
                        }
                    }
                    override fun onFailure(call: Call<ResponseModel>?, t: Throwable?) {
                        Log.d("ApiResponse",t.toString())
                    }
                });
            }).start()
        }

    }
}