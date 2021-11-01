package com.example.epoxy.view

import android.annotation.SuppressLint
import android.view.View
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.example.epoxy.R
import com.example.epoxy.databinding.ComponentRecentTransactionBinding

@EpoxyModelClass(layout = R.layout.component_recent_transaction)
abstract class RecentTransactionModel: EpoxyModelWithHolder<RecentTransactionModel.RecentTransactionHolder>() {

    @field:EpoxyAttribute
    var recentTransaction: String? = null

    @field:EpoxyAttribute
    var seeAll: String? = null


    @SuppressLint("SetTextI18n")
    override fun bind(holder: RecentTransactionModel.RecentTransactionHolder) {
        super.bind(holder)
        holder.binding.recentTransactionTextView.text = recentTransaction
        holder.binding.seeAllTextView.text = seeAll
    }



    class RecentTransactionHolder : EpoxyHolder() {
        lateinit var binding: ComponentRecentTransactionBinding
            private set

        override fun bindView(itemView: View) {
            binding = ComponentRecentTransactionBinding.bind(itemView)
        }
    }
}