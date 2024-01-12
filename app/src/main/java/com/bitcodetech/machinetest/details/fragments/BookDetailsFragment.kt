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
import com.bitcodetech.machinetest.factory.BookViewModelFactory
import com.bitcodetech.machinetest.models.Book

class BookDetailsFragment : Fragment() {
    private lateinit var binding: BookDetailsFragmentBinding

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
        binding.root.setOnClickListener{

        }

        return binding.root
    }
    }