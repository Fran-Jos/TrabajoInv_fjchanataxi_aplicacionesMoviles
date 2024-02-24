package com.biometric.fch.ui.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.biometric.fch.R
import com.biometric.fch.databinding.ActivityInicioBinding
import com.biometric.fch.databinding.ActivityRegisterBinding
import com.biometric.fch.ui.viewmodels.MainViewModel
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import java.util.concurrent.Executor

class Activity_registro : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    //El Executor permite ejecutar procesos en segundo plano
    private lateinit var executor: Executor

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_register)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initListener()
    }

    override fun onStart() {
        super.onStart()
    }

    private fun initListener() {

        binding.btnRegister.setOnClickListener {
            mainViewModel.sigInUserWithEmailAndPassword(
                binding.txtName.text.toString(),
                binding.txtPassword.text.toString()

            )
        }

    }




}