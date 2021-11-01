package com.example.epoxy.view.setting

import android.view.View
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.bumptech.glide.Glide
import com.example.epoxy.R
import com.example.epoxy.databinding.ComponentDiscoverItemBinding

@EpoxyModelClass(layout = R.layout.component_discover_item)
abstract class CardModel: EpoxyModelWithHolder<CardModel.CardViewHolder>() {


    @field:EpoxyAttribute
    var title: String? = null

    @field:EpoxyAttribute
    var image: String? = null

    @field:EpoxyAttribute
    var body: String? = null

    @EpoxyAttribute
    lateinit var clickListener: () -> Unit

    override fun bind(holder: CardViewHolder) {
        super.bind(holder)
        holder.binding.titleTextView.text = title
        Glide.with(holder.binding.discoverImageView)
            .load("https://p0.pikist.com/photos/454/434/vietnam-cute-girl-beautiful-camera-yellow-leaves-classic-autumn.jpg")
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.binding.discoverImageView)
        holder.binding.bodyTextView.text = body

    }

    class CardViewHolder : EpoxyHolder() {
        lateinit var binding: ComponentDiscoverItemBinding
            private set

        override fun bindView(itemView: View) {
            binding = ComponentDiscoverItemBinding.bind(itemView)
        }
    }

}