package com.example.epoxy.view.budget

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.epoxy.R
import com.example.epoxy.databinding.FragmentBudgetBinding

class BudgetFragment : Fragment() {

    private var _binding: FragmentBudgetBinding? = null
    private val binding get() = _binding!!
    private val viewModel: BudgetViewModel by activityViewModels()
    private val selectViewModel: SelectViewModel by activityViewModels()
    private val controller: BudgetController by lazy {
        BudgetController(
            selectedListener = { list ->
                selectViewModel.addBudget(list)
            }
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBudgetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observe()
    }

    private fun initView() {
        val linearLayoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.layoutManager = linearLayoutManager
        binding.recyclerView.setController(controller = controller)
        binding.recyclerView.requestModelBuild()
        binding.addFloatButton.setOnClickListener {
            findNavController().navigate(R.id.action_budgetFragment_to_budgetAddedFragment)
        }
    }

    private fun observe() {
        viewModel.budgets.observe(viewLifecycleOwner, { budgets ->
            controller.submitData(budgets)
        })
        selectViewModel.tests.observe(viewLifecycleOwner, { selects ->
            controller.submitSelect(selects)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}