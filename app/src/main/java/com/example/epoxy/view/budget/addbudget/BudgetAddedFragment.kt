package com.example.epoxy.view.budget.addbudget

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.epoxy.databinding.FragmentBudgetAddedBinding
import com.example.epoxy.view.budget.BudgetController
import com.example.epoxy.view.budget.BudgetViewModel
import com.example.epoxy.view.budget.SelectViewModel

class BudgetAddedFragment : Fragment() {

    private var _binding: FragmentBudgetAddedBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SelectViewModel by activityViewModels()
    private val controller: BudgetController by lazy {
        BudgetController(
            selectedListener = { list ->
                viewModel.removeBudget(list)
            }
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBudgetAddedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observe()
    }

    private fun initView(){
//        val linearLayoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.setController(controller = controller)
        binding.recyclerView.requestModelBuild()
    }

    private fun observe(){
        viewModel.selectedBudgets.observe(viewLifecycleOwner, { budgets ->
            controller.submitSelect(budgets)
            println(budgets.size)
        })

    }



}