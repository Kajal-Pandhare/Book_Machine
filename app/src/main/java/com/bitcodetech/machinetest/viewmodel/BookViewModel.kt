package com.bitcodetech.machinetest.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bitcodetech.machinetest.models.Book
import com.bitcodetech.machinetest.repository.BookRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BookViewModel(private val bookRepository: BookRepository
) : ViewModel() {

    val bookMutableLiveData = MutableLiveData<Boolean>()
    val books = ArrayList<Book>()

    fun fetchBooks(){
        CoroutineScope(Dispatchers.IO).launch {
            val books = bookRepository.fetchBooks()

            withContext(Dispatchers.Main){
                this@BookViewModel.books.addAll(books)
                bookMutableLiveData.postValue(true)
            }
        }
    }

}