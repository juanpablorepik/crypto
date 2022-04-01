package com.example.crypto.Data.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.crypto.Data.Models.CryptoModel
import com.example.crypto.R

class CryptoAdapter(private val cryptoList: List<CryptoModel>) : RecyclerView.Adapter<CryptoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CryptoViewHolder(layoutInflater.inflate(R.layout.item_crypto,parent,false))
    }

    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
       val item = cryptoList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = cryptoList.size

}