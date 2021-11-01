package com.example.epoxy.view.person

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.epoxy.TodoApp
import com.example.epoxy.model.Todo
import com.example.epoxy.utils.ResultOf
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PersonViewModel : ViewModel() {

    private val _todo: MutableLiveData<ArrayList<Todo>> = MutableLiveData(ArrayList())
    var todos: LiveData<ArrayList<Todo>> = _todo
    private val _todoo: MutableLiveData<Todo> = MutableLiveData()
    var todoo: LiveData<Todo> = _todoo

    fun getTodos() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val response = TodoApp.mainRepository.getTodo()) {
                is ResultOf.Success -> {
                    _todo.postValue(response.data)
                }

                is ResultOf.Error -> {
                    println("Error .... ${response.exception}")
                }
            }
        }
    }

    fun getTodoById(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = TodoApp.mainRepository.getTodoById(id = id)) {
                is ResultOf.Success -> {
                       _todoo.postValue(result.data)
                }
                is ResultOf.Error -> {
                    println("Error...")
                }
            }
        }
    }


}