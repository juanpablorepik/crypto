package com.example.crypto.Data.Adapter

import android.text.TextUtils.indexOf
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.crypto.Data.Models.CryptoModel
import com.example.crypto.R

class CryptoViewHolder (view: View) : RecyclerView.ViewHolder(view){

    val cryptoText = view.findViewById<TextView>(R.id.cryptoName)
    val cryptoText2 = view.findViewById<TextView>(R.id.cryptoSymbol)
    val cryptoPrice = view.findViewById<TextView>(R.id.cryptoPrice)

    fun render(crypto: CryptoModel){
        Log.d("TEXTO",crypto.name)
        Log.d("TEXTO",crypto.symbol)
        Log.d("PRICE",crypto.quote.USD?.price.toString())
        cryptoText.text = crypto.name
        cryptoText2.text = crypto.symbol
        cryptoPrice.text = "$ "+crypto.quote.USD?.price.toString()
            .substring(0, indexOf(crypto.quote.USD?.price.toString(),'.')+3)
    }

}