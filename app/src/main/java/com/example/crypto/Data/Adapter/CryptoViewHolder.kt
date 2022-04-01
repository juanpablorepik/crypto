package com.example.crypto.Data.Adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.crypto.Data.Models.CryptoModel
import com.example.crypto.Data.ApiRequest
import com.example.crypto.R

class CryptoViewHolder (view: View) : RecyclerView.ViewHolder(view){

    val cryptoText = view.findViewById<TextView>(R.id.cryptoName)
    val cryptoText2 = view.findViewById<TextView>(R.id.cryptoSymbol)

    fun render(crypto: CryptoModel){
        val data = ApiRequest.requestApi()
        cryptoText.text = crypto.name
        cryptoText2.text = crypto.symbol


    }

}