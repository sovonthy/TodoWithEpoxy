package com.example.epoxy.view.person

import android.view.View
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.example.epoxy.R
import com.example.epoxy.databinding.ComponentTodoItemBinding

@EpoxyModelClass(layout = R.layout.component_todo_item)
abstract class TodoItemModel: EpoxyModelWithHolder<TodoItemModel.NotificationViewHolder>() {


    @field:EpoxyAttribute
    var title: String? = null

    @field:EpoxyAttribute
    var userId: String? = null

    @field:EpoxyAttribute
    var completed: Boolean? = null

    @EpoxyAttribute
    lateinit var clickListener: () -> Unit

    override fun bind(holder: NotificationViewHolder) {
        super.bind(holder)
        holder.binding.todoTitleTextView.text = title
        holder.binding.userIdTextView.text = userId
        holder.binding.completedTexView.text = completed.toString()
        holder.binding.root.setOnClickListener {
            clickListener()
        }
    }

    class NotificationViewHolder : EpoxyHolder() {
        lateinit var binding: ComponentTodoItemBinding
            private set

        override fun bindView(itemView: View) {
            binding = ComponentTodoItemBinding.bind(itemView)
        }
    }

}