package com.bitcodetech.machinetest.details.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bitcodetech.machinetest.details.repository.BookDetailsRepository
import com.bitcodetech.machinetest.details.viewmodel.BookDetailsViewModel

class BookDetailsViewModelFactory(private val bookDetailsRepository: BookDetailsRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return BookDetailsViewModel(bookDetailsRepository)as T
    }
}