package com.example.epoxy.view.person

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.epoxy.R
import com.example.epoxy.databinding.FragmentPersonBinding
import com.example.epoxy.utils.Constant

class PersonFragment : Fragment() {

    private val viewModel: PersonViewModel by activityViewModels()
    private var _binding: FragmentPersonBinding? = null
    private val binding get() = _binding!!

    private val controller: TodoController by lazy {
        TodoController(
            clickListener = { item->
                val bundle = bundleOf(
                    Constant.Todo.ID to item.id,
                )
                findNavController().navigate(
                    R.id.action_personFragment_to_todoDetailFragment,
                    bundle
                )
            }
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPersonBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAction()
        observe()
    }

    private fun initAction(){
        val linearLayoutManager = LinearLayoutManager(requireContext())
        binding.todoRecyclerView.layoutManager = linearLayoutManager
        binding.todoRecyclerView.setController(controller = controller)
        viewModel.getTodos()
    }

    private fun observe(){
        viewModel.todos.observe(viewLifecycleOwner, { todos ->
            controller.submitData(todos)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}