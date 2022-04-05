package com.example.crypto.UI.Main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.crypto.Data.CryptoImpl
import com.example.crypto.Data.Models.CryptoModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CryptoMainViewModel : ViewModel() {

    public val cryptos: MutableLiveData<List<CryptoModel>> by lazy {
        MutableLiveData<List<CryptoModel>>()
    }

    fun getCryp(): MutableLiveData<List<CryptoModel>>{
        return cryptos
    }

    fun getApiInfo(): MutableLiveData<List<CryptoModel>> {
        val repo : CryptoImpl = CryptoImpl()

        CoroutineScope(Dispatchers.IO).launch {
            cryptos.postValue(repo.getCryptoList())
        }
        return cryptos;
    }
}