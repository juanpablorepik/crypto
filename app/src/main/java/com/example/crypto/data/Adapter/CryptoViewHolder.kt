package com.example.crypto.data.Adapter

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.crypto.common.Constants
import com.example.crypto.data.Models.CryptoModel
import com.example.crypto.R

class CryptoViewHolder (view: View) : RecyclerView.ViewHolder(view){

    val symbolText = view.findViewById<TextView>(R.id.symbolText)
    val nameText = view.findViewById<TextView>(R.id.nameText)
    val priceText = view.findViewById<TextView>(R.id.priceText)


    @SuppressLint("SetTextI18n")
    fun render(crypto: CryptoModel, selectedCur: String){
        val price = crypto.quote.get(selectedCur)?.price

        symbolText.text = crypto.symbol
        nameText.text = crypto.name

        if (price == null)
            priceText.text = "N/A"
        else
            priceText.text = Constants.CURRENCY_SYMBOL+String.format("%.2f", price)
    }
}