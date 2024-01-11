package com.bitcodetech.machinetest.details.network

import com.bitcodetech.machinetest.details.models.BookDetailsResponse
import com.bitcodetech.machinetest.models.BookResponse
import com.bitcodetech.machinetest.network.BookApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface BookDetailsApiService {

    @GET("new")
    suspend fun fetchBookDetails() : BookDetailsResponse

    companion object{
        private var bookDetailsApiService : BookDetailsApiService? = null

        fun getInstance() : BookDetailsApiService{
            if (bookDetailsApiService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://api.itbook.store/1.0/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                bookDetailsApiService = retrofit.create(BookDetailsApiService::class.java)
            }
            return bookDetailsApiService!!
        }
    }
}