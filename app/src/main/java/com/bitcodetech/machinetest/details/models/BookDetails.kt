package com.bitcodetech.machinetest.details.models

import java.io.Serializable

data class BookDetails(
    val subtitle : String,
    val isbn13 : String,
    val price : String,
    val url : String
) : Serializable
