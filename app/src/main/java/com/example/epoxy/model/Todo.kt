package com.example.epoxy.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Todo(
    val id: Int,
    @SerializedName("userId")
    val userId: Int,

    @SerializedName("title")
    val title: String,

    @SerializedName("completed")
    val completed: Boolean,
)