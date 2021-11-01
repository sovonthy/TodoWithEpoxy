package com.example.epoxy.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.epoxy.databinding.FragmentHomeBinding
import com.example.epoxy.view.HomeController

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val controller: HomeController by lazy {
        HomeController(
            context = requireActivity(),
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

   private fun initView(){
//       binding.recyclerView.setController(controller = controller)
//       binding.recyclerView.requestModelBuild()
   }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}