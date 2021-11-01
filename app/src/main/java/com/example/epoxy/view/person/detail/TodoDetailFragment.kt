package com.example.epoxy.view.person.detail

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.epoxy.databinding.FragmentTodoDetailBinding
import com.example.epoxy.utils.Constant
import com.example.epoxy.view.person.PersonViewModel

class TodoDetailFragment : Fragment() {
    private val viewModel: PersonViewModel by activityViewModels()
    private var _binding: FragmentTodoDetailBinding? = null
    private val binding get() = _binding!!
    private var todoId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        todoId = arguments?.getInt(Constant.Todo.ID)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTodoDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observe()
    }

    @SuppressLint("SetTextI18n")
    private fun initView(){
        binding.title.text = "TODO DETAIL"
        todoId?.let { viewModel.getTodoById(it) }
    }

    @SuppressLint("SetTextI18n")
    private fun observe(){
       viewModel.todoo.observe(viewLifecycleOwner, { todo ->
           binding.titleTextView.text = "Title: " + todo.title
           binding.userIdTextView.text = "User id: " + todo.userId.toString()
           binding.completedTexView.text = "Completed: " + todo.completed.toString()
       })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}