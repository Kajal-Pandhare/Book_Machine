package com.bitcodetech.machinetest.details.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bitcodetech.machinetest.adapter.BookAdapter
import com.bitcodetech.machinetest.databinding.BookDetailsFragmentBinding
import com.bitcodetech.machinetest.details.factory.BookDetailsViewModelFactory
import com.bitcodetech.machinetest.details.models.BookDetails
import com.bitcodetech.machinetest.details.network.BookDetailsApiService
import com.bitcodetech.machinetest.details.repository.BookDetailsRepository
import com.bitcodetech.machinetest.details.viewmodel.BookDetailsViewModel
import com.bitcodetech.machinetest.factory.BookViewModelFactory
import com.bitcodetech.machinetest.models.Book

class BookDetailsFragment : Fragment() {
    private lateinit var binding: BookDetailsFragmentBinding
    private lateinit var bookDetailsViewModel: BookDetailsViewModel
    private var book: Book? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = BookDetailsFragmentBinding.inflate(layoutInflater)

        if(arguments != null) {
            book = requireArguments().getSerializable("books") as Book
            binding.book = book
        }

        return binding.root
    }

    private fun initListeners(){
        if (arguments!= null){
            requireArguments().getSerializable("books",)
        }
    }
    @SuppressLint("NotifyDataSetChanged")
    private fun initObserver(){
        bookDetailsViewModel.bookDetailsMutableLiveData.observe(
            viewLifecycleOwner
        ){
            if (it){

            }
        }
    }
    private fun initModels(){
        bookDetailsViewModel = ViewModelProvider(
            this,
            BookDetailsViewModelFactory(
                BookDetailsRepository(
                    BookDetailsApiService.getInstance()
                )
            )
        )[BookDetailsViewModel::class.java]
    }
}