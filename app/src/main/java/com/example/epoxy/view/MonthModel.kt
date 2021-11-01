package com.example.epoxy.view


import android.view.View
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.example.epoxy.R
import com.example.epoxy.databinding.ComponentMonthBinding

@EpoxyModelClass(layout = R.layout.component_month)
abstract class MonthModel : EpoxyModelWithHolder<MonthModel.MonthViewHolder>() {

    @field:EpoxyAttribute
    var monthTextView: String? = null

    @field:EpoxyAttribute
    var price: String? = null

    @field:EpoxyAttribute
    var lastMonth: String? = null

    @field:EpoxyAttribute
    var fee: String? = null

    override fun bind(holder: MonthViewHolder) {
        super.bind(holder)
        holder.binding.monthTextView.text = monthTextView
        holder.binding.textView.text = price
        holder.binding.lastMonth.text = lastMonth
        holder.binding.percentage.text = fee    }

    class MonthViewHolder : EpoxyHolder() {
        lateinit var binding: ComponentMonthBinding
            private set

        override fun bindView(itemView: View) {
            binding = ComponentMonthBinding.bind(itemView)
        }
    }

}