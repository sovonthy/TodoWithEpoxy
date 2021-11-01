package com.example.epoxy.view.setting

import com.airbnb.epoxy.EpoxyController
import com.example.epoxy.R
import com.example.epoxy.model.Budget
import com.example.epoxy.model.Select
import com.example.epoxy.model.Todo
import com.example.epoxy.view.budget.select
import java.util.concurrent.CopyOnWriteArrayList

class CardController(
    private val clickListener: ((Todo) -> Unit)? = null
) : EpoxyController() {

    private var budgets: CopyOnWriteArrayList<Budget> = CopyOnWriteArrayList()
    private var selects: CopyOnWriteArrayList<Select> = CopyOnWriteArrayList()
    private var selectedBudget: Select?= null

    fun submitSelect(list: ArrayList<Select>) {
        selects.clear()
        selects.addAll(list)
        requestModelBuild()
    }

    override fun buildModels() {

        selects.forEach { item ->
            select {
                id(item.id)
                title(item.title)
                description(item.description)
                image(item.image)
                background(
                    if (item.selected)  R.drawable.background_border_selected else R.drawable.background_border_diselected
                )
                selected(item.selected)
                clickListener {
                    if(this@CardController.selectedBudget != null) {
                        this@CardController.selectedBudget?.selected = false
                    }
                    item.selected = !item.selected
                    if(item.id != this@CardController.selectedBudget?.id) {
                        this@CardController.selectedBudget = item
                    }
                    this@CardController.requestModelBuild()
                }
            }
        }

    }
}





