package com.bitcodetech.machinetest.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bitcodetech.machinetest.commons.Repository
import com.bitcodetech.machinetest.details.repository.BookDetailsRepository
import com.bitcodetech.machinetest.details.viewmodel.BookDetailsViewModel
import com.bitcodetech.machinetest.repository.BookRepository
import com.bitcodetech.machinetest.viewmodel.BookViewModel
import java.lang.Exception

class BookViewModelFactory(private val bookRepository: BookRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return BookViewModel(bookRepository) as T
    }
        /*if(modelClass.isAssignableFrom(BookViewModel::class.java) && repository is BookRepository) {
            return BookViewModel(repository) as T
        }

        if(modelClass.isAssignableFrom(BookDetailsViewModel::class.java) && repository is BookDetailsRepository) {
            return BookDetailsViewModel(repository) as T
        }

        throw Exception("unable to create view model")
    }*/
}