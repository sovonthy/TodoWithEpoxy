package com.example.epoxy.repository

import android.content.Context
import com.example.epoxy.data.http.AppService
import com.example.epoxy.model.Todo
import com.example.epoxy.utils.ResultOf
import retrofit2.Response

class MainRepository(
    private val context: Context? = null,
    private val appService: AppService? = null
) {
    suspend fun getTodo(): ResultOf<ArrayList<Todo>> {
        return safeApiCall {
            appService!!.getTodo()
        }
    }

    suspend fun getTodoById(id: Int): ResultOf<Todo> {
            return safeApiCall {
                appService!!.getTodo(id = id)
            }
    }


    private suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>): ResultOf<T> {
        return try {
            val response = call.invoke()
            if (response.isSuccessful) {
                ResultOf.Success(response.body()!!)
            } else {
                ResultOf.Error(response.errorBody()?.toString() ?: "Something went wrong")
            }

        } catch (e: Exception) {
            ResultOf.Error(e.message ?: "Internet error runs")
        }
    }
}