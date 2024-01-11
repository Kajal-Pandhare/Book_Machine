package com.bitcodetech.machinetest.repository

import com.bitcodetech.machinetest.models.Book
import com.bitcodetech.machinetest.network.BookApiService

class BookRepository(private val bookApiService: BookApiService) {

    suspend fun fetchBooks() :ArrayList<Book>{
        return bookApiService.fetchBooks().books
    }
}