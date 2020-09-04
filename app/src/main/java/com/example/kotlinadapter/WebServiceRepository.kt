package com.example.kotlinadapter

class WebServiceRepository() {

    private val call = WikiApi.service

    suspend fun getHits(name: String) = call.getHits(name)
}