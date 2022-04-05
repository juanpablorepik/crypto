package com.example.crypto.UI.Main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.crypto.Data.Adapter.CryptoAdapter
import com.example.crypto.Data.CryptoImpl
import com.example.crypto.Data.CryptoProvider
import com.example.crypto.Data.Models.CryptoModel
import com.example.crypto.R
import com.example.crypto.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CryptoMain : AppCompatActivity() {
    //var data : LiveData<CryptoModel>()
    private lateinit var binding : ActivityMainBinding
    val cryptoViewModel : CryptoMainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        cryptoViewModel.getApiInfo()
        cryptoViewModel.cryptos.observe(this, Observer {
            val recyclerView = binding.recyclerViewCrypto
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = CryptoAdapter(cryptoViewModel.getCryp().value!!.toList())
        })

    }

}