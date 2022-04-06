package com.example.crypto.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crypto.common.Constants
import com.example.crypto.data.CryptoImpl
import com.example.crypto.data.Interface.ICryptoRepository
import com.example.crypto.data.Models.CryptoModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CryptoMainViewModel constructor(private val repository : ICryptoRepository): ViewModel() {

    val cryptos: MutableLiveData<List<CryptoModel>> by lazy {
        MutableLiveData<List<CryptoModel>>()
    }

    private val _selectedCurrency: MutableLiveData<String> = MutableLiveData(Constants.CURRENCY_ARS)
    val selectedCurrency: LiveData<String> = _selectedCurrency

    companion object{
        var currencyType : String = "USD"
        val CURRENCIES= listOf<String>(Constants.CURRENCY_USD,Constants.CURRENCY_ARS)
    }

    fun setCurrencyType(cur : String){
        currencyType = cur
    }

    fun getCurrencies():  List<String>{
        return  CURRENCIES;
    }

    fun getCryp(): MutableLiveData<List<CryptoModel>>{
        return cryptos
    }

    fun update(){

        viewModelScope.launch {
            cryptos.postValue(repository.getCryptoList(_selectedCurrency.value!!))
            Log.d("CURRENCY",cryptos.value?.toList().toString())
        }
    }

    fun onSelectedCurrency(currency : String){
        _selectedCurrency.value = currency
    }
}