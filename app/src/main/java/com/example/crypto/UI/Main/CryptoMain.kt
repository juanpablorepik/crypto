package com.example.crypto.UI.Main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.crypto.Data.Adapter.CryptoAdapter
import com.example.crypto.Data.CryptoProvider
import com.example.crypto.R
import com.example.crypto.databinding.ActivityMainBinding

class CryptoMain : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    val cryptoViewModel : CryptoMainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        cryptoViewModel.users.observe(this, Observer {

        })

        initRecyclerView()
    }

    fun initRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewCrypto)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CryptoAdapter(CryptoProvider.cryptoList)
    }
}