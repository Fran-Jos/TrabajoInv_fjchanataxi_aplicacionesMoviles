package com.biometric.fch.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.biometric.fch.R
import com.biometric.fch.databinding.FragmentCharactersBinding
import com.biometric.fch.ui.adapters.BAdapter
import com.biometric.fch.ui.viewmodels.ApiBebidaViewModels



class CharactersFragment : Fragment() {

    private lateinit var binding: FragmentCharactersBinding
    private val adapter = BAdapter()
    private val viewModel: ApiBebidaViewModels by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCharactersBinding.bind(
            inflater.inflate(
                R.layout.fragment_characters,
                container,
                false
            )
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        initObservers()
        initRecyclerView()
        viewModel.getAllBebidas()
    }

    private fun initObservers() {

        viewModel.listItems.observe(requireActivity()) {
            binding.animationView.visibility = View.VISIBLE
            adapter.submitList(it)
            binding.animationView.visibility = View.GONE
        }

        viewModel.error.observe(requireActivity()) {
            adapter.submitList(emptyList())
            adapter.notifyDataSetChanged()
        }

    }

    private fun initRecyclerView() {
        binding.rvUsers.adapter = adapter
        binding.rvUsers.layoutManager =
            LinearLayoutManager(
                requireActivity(),
                LinearLayoutManager.VERTICAL,
                false
            )
    }


    private fun initListeners(){
        binding.swiperv.setOnRefreshListener {
            viewModel.getAllBebidas()
            binding.swiperv.isRefreshing = false
        }
    }

}