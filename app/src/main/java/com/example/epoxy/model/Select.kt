package com.example.epoxy.model

data class Select(
    val id: Int,
    val title: String,
    val description: String,
    val image: String,
    var selected : Boolean
)