package com.example.kotlinadapter

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

object WikiApi {
    private const val URL = "https://en.wikipedia.org"

    // https://en.wikipedia.org/w/api.php?action=query&format=json&list=search&srsearch=Trump

    object Model {
        data class Result(val query: Query)
        data class Query(val searchinfo: SearchInfo)
        data class SearchInfo(val totalhits: Int)
    }

    interface Service {
        @GET("/w/api.php?action=query&format=json&list=search")
        suspend fun getHits(@Query("srsearch") name: String): Model.Result
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(Service::class.java)!!
}