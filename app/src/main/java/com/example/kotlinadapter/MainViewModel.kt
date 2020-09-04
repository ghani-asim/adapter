package com.example.kotlinadapter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers

class MainViewModel: ViewModel() {

    private val repository: WebServiceRepository = WebServiceRepository()

    fun hits(name: String) = liveData(Dispatchers.IO) {
        val retrievedHits = repository.getHits(name)

        emit(retrievedHits)
    }
}