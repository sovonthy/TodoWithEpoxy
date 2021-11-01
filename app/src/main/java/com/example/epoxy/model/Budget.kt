package com.example.epoxy.model

data class Budget(
    val id: Int,
    val title: String,
    val price: String,
    val image: String,
    var selected : Boolean
)