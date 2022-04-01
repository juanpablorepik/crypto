package com.example.crypto.UI.Main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.crypto.Data.Models.CryptoModel

class CryptoMainViewModel : ViewModel() {
     val users = MutableLiveData<List<CryptoModel>>()

    fun getCryptos(): LiveData<List<CryptoModel>> {
        return users;
    }
}