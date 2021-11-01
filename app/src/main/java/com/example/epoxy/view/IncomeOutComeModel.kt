package com.example.epoxy.view

import android.annotation.SuppressLint
import android.view.View
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.bumptech.glide.Glide
import com.example.epoxy.R
import com.example.epoxy.databinding.ComponentIncomeOutcomeBinding

@EpoxyModelClass(layout = R.layout.component_income_outcome)
abstract class IncomeOutComeModel: EpoxyModelWithHolder<IncomeOutComeModel.InComeOutComeHolder>() {

    @field:EpoxyAttribute
    var inComePrice: String? = null

    @field:EpoxyAttribute
    var expensesPrice: String? = null


    @SuppressLint("SetTextI18n")
    override fun bind(holder: IncomeOutComeModel.InComeOutComeHolder) {
        super.bind(holder)
        holder.binding.incomePriceTextView.text = inComePrice
        holder.binding.expensesPriceTextView.text = expensesPrice
    }



    class InComeOutComeHolder : EpoxyHolder() {
        lateinit var binding: ComponentIncomeOutcomeBinding
            private set

        override fun bindView(itemView: View) {
            binding = ComponentIncomeOutcomeBinding.bind(itemView)
        }
    }
}