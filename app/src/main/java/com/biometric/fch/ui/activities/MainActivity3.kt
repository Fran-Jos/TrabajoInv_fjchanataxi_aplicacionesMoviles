package com.biometric.fch.ui.activities

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.biometric.fch.R
import com.biometric.fch.databinding.Activity3Binding
import com.biometric.fch.ui.adapters.BAdapter

import com.biometric.fch.ui.viewmodels.ApiBebidaViewModels


class MainActivity3 : AppCompatActivity() {

    private lateinit var binding: Activity3Binding
    private val adapter = BAdapter()
    private val viewModel: ApiBebidaViewModels by viewModels()
    private lateinit var dialog: AlertDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        initListeners()
        initObservers()
        initRecyclerView()

        dialog = AlertDialog.Builder(this)
            .setMessage(getString(R.string.carga_datos))
            .setTitle(getString(R.string.title_dialog))
            .setPositiveButton(getString(R.string.aceptar)) { _, _ ->
                viewModel.getAllBebidas()
            }
            .setNegativeButton(getString(R.string.cancelar)) { dialog, _ ->
                dialog.dismiss()
            }
            .setCancelable(false)
            .create()

        dialog.show()

    }

    private fun initObservers() {

        viewModel.listItems.observe(this) {
            binding.animationView.visibility = View.VISIBLE
            adapter.submitList(it)
            binding.animationView.visibility = View.GONE
        }

        viewModel.error.observe(this) {
            adapter.submitList(emptyList())
            adapter.notifyDataSetChanged()
        }
    }

    private fun initRecyclerView() {
        binding.rvUsers.adapter = adapter
        binding.rvUsers.layoutManager =
            LinearLayoutManager(
                this@MainActivity3,
                LinearLayoutManager.VERTICAL,
                false
            )
    }

    private fun initListeners() {
        binding.swiperv.setOnRefreshListener {
            viewModel.getAllBebidas()
            binding.swiperv.isRefreshing = false
        }
    }
}