package com.example.epoxy.view.budget

import android.view.View
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.example.epoxy.R
import com.example.epoxy.databinding.ComponentDateBudgetItemBinding

@EpoxyModelClass(layout = R.layout.component_date_budget_item)
abstract class DateBudgetModel : EpoxyModelWithHolder<DateBudgetModel.DateBudgetViewHolder>() {

    @field:EpoxyAttribute
    var date: String? = null

    @field:EpoxyAttribute
    var price: String? = null

    override fun bind(holder: DateBudgetViewHolder) {
        super.bind(holder)
        holder.binding.dateTextView.text = date
        holder.binding.priceTextView.text = price
    }

    class DateBudgetViewHolder : EpoxyHolder() {
        lateinit var binding: ComponentDateBudgetItemBinding
            private set

        override fun bindView(itemView: View) {
            binding = ComponentDateBudgetItemBinding.bind(itemView)
        }
    }

}