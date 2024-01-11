package com.bitcodetech.machinetest.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bitcodetech.machinetest.R
import com.bitcodetech.machinetest.databinding.BookViewBinding
import com.bitcodetech.machinetest.details.models.BookDetails
import com.bitcodetech.machinetest.fragments.BookFragment
import com.bitcodetech.machinetest.models.Book
import com.bumptech.glide.Glide

class BookAdapter(private val books : ArrayList<Book>
):
RecyclerView.Adapter<BookAdapter.BookViewHolder>(){
    private lateinit var binding: BookViewBinding


    interface OnBookImageListener{
        fun onBookCLick(book: Book, position: Int, bookAdapter: BookAdapter)
    }
     var onBookImageListener : OnBookImageListener? = null

    inner class BookViewHolder(view: View):RecyclerView.ViewHolder(view){

        val binding : BookViewBinding

        init {
            binding = BookViewBinding.bind(view)
            binding.root.setOnClickListener {
                onBookImageListener?.onBookCLick(
                    books[adapterPosition],
                    adapterPosition,
                   this@BookAdapter
                )

            }
        }
    }

    override fun getItemCount() = books.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.book_view,null)
        return BookViewHolder(view)
    }

    @SuppressLint("CheckResult")
    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = books[position]

        //holder.txtTitle.text = book.title
       holder.binding.txtTitle.text = book.title
      //  holder.binding.txtSubtitle.text = book.subtitle

        Glide.with(holder.itemView)
            .load(books[position].image)
            .error(R.mipmap.ic_launcher)
            .placeholder(R.mipmap.ic_launcher)
            .circleCrop()
            .into(holder.binding.imgBooks)

    }

}