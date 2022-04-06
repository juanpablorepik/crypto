package com.example.crypto.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.crypto.data.Adapter.CryptoAdapter
import com.example.crypto.data.CryptoImpl
import com.example.crypto.databinding.ActivityMainBinding

class CryptoMain : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val cryptoViewModel = CryptoMainViewModel(CryptoImpl())

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val adapterSpinner = ArrayAdapter(this,android.R.layout.simple_spinner_item,CryptoMainViewModel.CURRENCIES)
        binding.curSpinner.adapter = adapterSpinner


        binding.curSpinner.onItemSelectedListener = object:
        AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                cryptoViewModel.onSelectedCurrency(CryptoMainViewModel.CURRENCIES[position])
                Log.d("CURRENCY",CryptoMainViewModel.CURRENCIES[position])
                cryptoViewModel.update()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        cryptoViewModel.update()

        cryptoViewModel.cryptos.observe(this, Observer {
            val recyclerView = binding.recyclerViewCrypto
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = CryptoAdapter(cryptoViewModel.getCryp().value!!.toList(),cryptoViewModel.selectedCurrency.value!!)
        })


    }
}