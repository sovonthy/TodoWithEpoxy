package com.example.epoxy.view

import android.view.View
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.example.epoxy.R
import com.example.epoxy.databinding.ComponentCashBinding

@EpoxyModelClass(layout = R.layout.component_cash)
abstract class HomeModel : EpoxyModelWithHolder<HomeModel.CaseViewHolder>() {

    @field:EpoxyAttribute
    var cashTextView: String? = null

    @field:EpoxyAttribute
    var textView: String? = null

    @field:EpoxyAttribute
    var showDetails: String? = null

    override fun bind(holder: CaseViewHolder) {
        super.bind(holder)
        holder.binding.cashFlowTextView.text = cashTextView
        holder.binding.textView.text = textView
        holder.binding.detailTextView.text = showDetails
    }

    class CaseViewHolder : EpoxyHolder() {
        lateinit var binding: ComponentCashBinding
            private set

        override fun bindView(itemView: View) {
            binding = ComponentCashBinding.bind(itemView)
        }
    }

}