package com.bitcodetech.machinetest.details.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bitcodetech.machinetest.details.models.BookDetails
import com.bitcodetech.machinetest.details.repository.BookDetailsRepository
import com.bitcodetech.machinetest.models.Book
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BookDetailsViewModel(private val bookDetailsRepository: BookDetailsRepository
) : ViewModel() {
    val bookDetailsMutableLiveData = MutableLiveData<Boolean>()
    val bookDetails = ArrayList<BookDetails>()

    fun fetchBookDetails(){
        CoroutineScope(Dispatchers.IO).launch {
            val bookDetails = bookDetailsRepository.fetchBookDetails()

            withContext(Dispatchers.Main){
                this@BookDetailsViewModel.bookDetails.addAll(bookDetails)
                bookDetailsMutableLiveData.postValue(true)
            }
        }
    }

}