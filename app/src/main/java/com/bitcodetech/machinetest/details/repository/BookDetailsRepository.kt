package com.bitcodetech.machinetest.details.repository

import com.bitcodetech.machinetest.commons.Repository
import com.bitcodetech.machinetest.details.models.BookDetails
import com.bitcodetech.machinetest.details.network.BookDetailsApiService
import com.bitcodetech.machinetest.models.Book
import com.bitcodetech.machinetest.models.BookResponse
import com.bitcodetech.machinetest.network.BookApiService

class BookDetailsRepository(private val bookDetailsApiService: BookDetailsApiService) {
    suspend fun fetchBookDetails() : ArrayList<BookDetails> {
        return bookDetailsApiService.fetchBookDetails().book
    }
}