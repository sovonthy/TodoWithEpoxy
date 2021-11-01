package com.example.epoxy.view.person

import android.util.Log
import com.airbnb.epoxy.EpoxyController
import com.example.epoxy.R
import com.example.epoxy.TodoApp
import com.example.epoxy.model.Todo
import com.example.epoxy.view.*
import java.util.concurrent.CopyOnWriteArrayList

class TodoController(
    private var clickListener: ((Todo) -> Unit)? = null
) : EpoxyController() {

    private var todos: CopyOnWriteArrayList<Todo> = CopyOnWriteArrayList()

    fun submitData(list: ArrayList<Todo>) {
        todos.clear()
        todos.addAll(list)
        requestModelBuild()
    }

    override fun buildModels() {
        if (todos.isNotEmpty()) {
            todos.forEach { item ->
                todoItem {
                    id(item.id)
                    title(item.title)
                    userId(item.userId.toString())
                    completed(item.completed)
                    clickListener {
                        this@TodoController.clickListener?.invoke(item)
                        TodoApp.appContext.getColor(R.color.ligtblue)

                    }
                }
            }
        }
    }
}