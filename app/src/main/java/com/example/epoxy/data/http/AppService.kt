package com.example.epoxy.data.http

import com.example.epoxy.model.Todo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface AppService {

    @GET("/todos")
    suspend fun getTodo(): Response<ArrayList<Todo>>

    @GET("/todos/{id}")
    suspend fun getTodo(
        @Path("id") id: Int
    ): Response<Todo>
}

