package com.example.epoxy.view.budget

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.epoxy.model.Select

class SelectViewModel : ViewModel() {
    val tests: MutableLiveData<ArrayList<Select>> = MutableLiveData(ArrayList())
    val selectedBudgets: MutableLiveData<ArrayList<Select>> = MutableLiveData(ArrayList())
    private val tempSelects: ArrayList<Select> = ArrayList()

    init {
        if (tests.value?.isEmpty()!!) {
            val tempList: ArrayList<Select> = ArrayList()
            List(10) {
                tempList.add(Select(it, "SQL ${it}","Hello, hers is SQL course","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRb7hEAIkelA-z9h4-7Zl4NI4kKRxO4BUJCPgrGkdxwu3Ga4rwYjozflnWmh5FdRk4yPHI&usqp=CAU",false))
            }

            tempSelects.addAll(tempList)
            tests.postValue(tempSelects)

        }
    }

    fun addBudget(list: ArrayList<Select>) {
        selectedBudgets.postValue(list)
    }

    fun removeBudget(list: ArrayList<Select>){
        val termBudget = selectedBudgets.value
        list.forEach {
            termBudget?.remove(it)
        }
        selectedBudgets.postValue(termBudget)
    }


}