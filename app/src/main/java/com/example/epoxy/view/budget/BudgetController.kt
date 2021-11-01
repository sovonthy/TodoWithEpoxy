package com.example.epoxy.view.budget

import com.airbnb.epoxy.EpoxyController
import com.example.epoxy.R
import com.example.epoxy.model.Budget
import com.example.epoxy.model.Select
import com.example.epoxy.model.Todo
import java.util.concurrent.CopyOnWriteArrayList

class BudgetController(
    private val clickListener: ((Todo) -> Unit)? = null,
    private val selectedListener: (ArrayList<Select>) -> Unit
) : EpoxyController() {

    private var budgets: CopyOnWriteArrayList<Budget> = CopyOnWriteArrayList()
    private var selects: CopyOnWriteArrayList<Select> = CopyOnWriteArrayList()
    private var selectedBudgets: ArrayList<Select> = ArrayList()

    fun submitData(list: ArrayList<Budget>) {
        budgets.clear()
        budgets.addAll(list)
        requestModelBuild()
    }

    fun submitSelect(list: ArrayList<Select>) {
        selects.clear()
        selects.addAll(list)
        requestModelBuild()
    }

    override fun buildModels() {

//            budgets.forEach { item ->
//                budget {
//                    id(item.id)
//                    title(item.title)
//                    price(item.price)
//                    image(item.image)
//                    background(
//                        if (item.selected == true)  R.drawable.background_border_diselected else R.drawable.background_border_selected
//                    )
//                    selected(item.selected)
//                    clickListener {
//                        item.selected = item.selected
//                            this@BudgetController.requestModelBuild()
//                    }
//                }
//            }

        selects.forEach { item ->
            select {
                id(item.id)
                title(item.title)
                description(item.description)
                image(item.image)
                background(
                    if (item.selected) R.drawable.background_border_selected else R.drawable.background_border_diselected
                )
                selected(item.selected)
                clickListener {
                    if (this@BudgetController.selectedBudgets.isNotEmpty()) {
                        if (this@BudgetController.selectedBudgets.contains(item)) {
                            this@BudgetController.selectedBudgets.remove(item)
                        } else {
                            this@BudgetController.selectedBudgets.add(item)
                        }
                    } else {
                        this@BudgetController.selectedBudgets.add(item)
                    }
                    item.selected = !item.selected
                    this@BudgetController.selectedListener(this@BudgetController.selectedBudgets)
                    this@BudgetController.requestModelBuild()
                }
            }
        }

    }
}
