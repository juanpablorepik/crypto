package com.example.crypto.ui.main

import com.example.crypto.CoroutineTestRule
import com.example.crypto.data.Interface.ICryptoRepository
import org.junit.Assert.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock

@ExperimentalCoroutinesApi
class CryptoMainViewModelTest {

    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    @Test
    fun `Update must populate crypto list when response is ok`() = coroutineTestRule.testDispatcher.runBlockingTest {
        val repository: ICryptoRepository = mock(ICryptoRepository::class.java)
        val viewModel = CryptoMainViewModel(repository = repository)

        viewModel.update()
        assertTrue(viewModel.cryptos.value!!.isEmpty())
    }
}