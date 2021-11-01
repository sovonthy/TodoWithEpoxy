package com.example.epoxy.view.budget

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.epoxy.model.Budget
import com.example.epoxy.model.Select

class BudgetViewModel : ViewModel() {
    val budgets: MutableLiveData<ArrayList<Budget>> = MutableLiveData(ArrayList())


    private val tempBudgets: ArrayList<Budget> = ArrayList()

    init {
        if (budgets.value?.isEmpty()!!) {
            val tempList: ArrayList<Budget> = ArrayList()
            List(20) {
                tempList.add(Budget(it, "Cafe","$2.09","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRb7hEAIkelA-z9h4-7Zl4NI4kKRxO4BUJCPgrGkdxwu3Ga4rwYjozflnWmh5FdRk4yPHI&usqp=CAU",false))
            }

            tempBudgets.addAll(tempList)
            budgets.postValue(tempBudgets)
        }
    }


}