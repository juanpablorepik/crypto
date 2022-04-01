package com.example.crypto.Data

import com.example.crypto.Data.Models.CryptoModel
import com.example.crypto.Data.Models.QuoteModel
import com.example.crypto.Data.Models.USDModel

class CryptoProvider {
    companion object{
        val cryptoList = listOf<CryptoModel>(
            CryptoModel("1","Bitcoin","BTC", QuoteModel(USDModel(121.16))),
            CryptoModel("2","Ethereum","ETH", QuoteModel(USDModel(121.16))),
            CryptoModel("3","USDT","USTD", QuoteModel(USDModel(121.16))),
            CryptoModel("4","Solana","SOL", QuoteModel(USDModel(121.16))),
            CryptoModel("5","Bitcoin","BTC", QuoteModel(USDModel(121.16))),
            CryptoModel("6","Ethereum","ETH", QuoteModel(USDModel(121.16))),
            CryptoModel("7","USDT","USTD", QuoteModel(USDModel(121.16))),
            CryptoModel("8","Solana","SOL", QuoteModel(USDModel(121.16))),
            CryptoModel("9","Bitcoin","BTC", QuoteModel(USDModel(121.16))),
            CryptoModel("10","Ethereum","ETH", QuoteModel(USDModel(121.16))),
            CryptoModel("11","USDT","USTD", QuoteModel(USDModel(121.16))),
            CryptoModel("12","Solana","SOL", QuoteModel(USDModel(121.16))),
            CryptoModel("13","Bitcoin","BTC", QuoteModel(USDModel(121.16))),
            CryptoModel("14","Ethereum","ETH", QuoteModel(USDModel(121.16))),
            CryptoModel("15","USDT","USTD", QuoteModel(USDModel(121.16))),
            CryptoModel("16","Solana","SOL", QuoteModel(USDModel(121.16))),
        )

    }
}