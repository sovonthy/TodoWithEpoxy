package com.example.epoxy.view.setting

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.epoxy.R
import com.example.epoxy.databinding.FragmentBudgetBinding
import com.example.epoxy.databinding.FragmentSettingBinding
import com.example.epoxy.view.budget.BudgetController
import com.example.epoxy.view.budget.BudgetViewModel
import com.example.epoxy.view.budget.SelectViewModel

class SettingFragment : Fragment() {

    private var _binding: FragmentSettingBinding? = null
    private val binding get() = _binding!!
    private val viewModel: BudgetViewModel by activityViewModels()
    private val selectViewModel: SelectViewModel by activityViewModels()
    private val controller: CardController by lazy {
        CardController()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observe()
    }

    private fun initView(){
//        val linearLayoutManager = LinearLayoutManager(requireContext())
//        binding.recyclerView.layoutManager = linearLayoutManager
//        binding.recyclerView.setController(controller = controller)
//        binding.recyclerView.requestModelBuild()
    }

    private fun observe(){
        selectViewModel.tests.observe(viewLifecycleOwner, { selects ->
            controller.submitSelect(selects)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}