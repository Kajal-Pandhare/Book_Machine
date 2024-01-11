package com.bitcodetech.machinetest.details.models

import com.google.gson.annotations.SerializedName

data class BookDetailsResponse(
    @SerializedName("books")
    val book : ArrayList<BookDetails>
)
