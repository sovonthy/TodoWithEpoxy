package com.example.epoxy.view

import android.annotation.SuppressLint
import android.view.View
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.bumptech.glide.Glide
import com.example.epoxy.R
import com.example.epoxy.databinding.ComponentTransactionBinding

@EpoxyModelClass(layout = R.layout.component_transaction)
abstract class TransactionModel : EpoxyModelWithHolder<TransactionModel.TransactionHolder>() {

    @field:EpoxyAttribute
    var transactionId: Int? = null

    @field:EpoxyAttribute
    var title: String? = null

    @field:EpoxyAttribute
    var subTitle: String? = null

    @field:EpoxyAttribute
    var price: String? = null

    @field:EpoxyAttribute
    var image: String? = null

    @SuppressLint("SetTextI18n")
    override fun bind(holder: TransactionHolder) {
        super.bind(holder)
        holder.binding.titleTextView.text = title
        holder.binding.subTitleTextView.text = subTitle
        holder.binding.priceTextView.text = price
        Glide.with(holder.binding.profileImageView)
            .load("https://photoplex.net/wp-content/uploads/2021/04/90.jpg")
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.binding.profileImageView)
    }

    class TransactionHolder : EpoxyHolder() {
        lateinit var binding: ComponentTransactionBinding
            private set

        override fun bindView(itemView: View) {
            binding = ComponentTransactionBinding.bind(itemView)
        }
    }
}

