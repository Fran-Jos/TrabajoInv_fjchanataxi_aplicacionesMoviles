package com.biometric.fch.ui.activities

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import com.biometric.fch.R
import com.biometric.fch.databinding.ActivityInicioBinding
import com.biometric.fch.ui.viewmodels.MainViewModel
import com.google.android.material.snackbar.Snackbar
import java.util.concurrent.Executor

class Activity_inicio: AppCompatActivity() {

    //El Executor permite ejecutar procesos en segundo plano
    private lateinit var executor: Executor

    //Va a mostrar los eventos del biometrico
    private lateinit var biometricPrompt: BiometricPrompt

    //EL dialogo que se va a mostrar
    private lateinit var promptInfo: BiometricPrompt.PromptInfo

    private lateinit var btnFinger: ImageView
    private lateinit var txtInfo: TextView

    private val mainViewModel: MainViewModel by viewModels()

    private lateinit var binding: ActivityInicioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_inicio)
        binding = ActivityInicioBinding.inflate(layoutInflater)
        setContentView(binding.root)



        initListener()
        initObservables()
        AuteticationVariables()
        mainViewModel.checkBiometric(this)

    }
    override fun onStart() {
        super.onStart()
    }

    private fun initListener() {




        binding.imgFinger.setOnClickListener {
            biometricPrompt.authenticate(promptInfo)
        }

        binding.micro.setOnClickListener {

            //startActivity(Intent(this@Activity_inicio, Activity_registro::class.java))

            mainViewModel.sigInUserWithEmailAndPassword(
                binding.txtUser.text.toString(),
                binding.txtPassword.text.toString()

            )
        }


        binding.button2.setOnClickListener {
            mainViewModel.sigInUserWithEmailAndPassword(

                binding.txtUser.text.toString(),
                binding.txtPassword.text.toString()
            )
        }

    }


    private fun AuteticationVariables() {
        executor = ContextCompat.getMainExecutor(this)
        biometricPrompt = BiometricPrompt(this, executor,
            object : BiometricPrompt.AuthenticationCallback() {
                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                    super.onAuthenticationSucceeded(result)
                    startActivity(Intent(this@Activity_inicio, MainActivity2::class.java))
                }
            })
        promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle("Biometric login for my app")
            .setSubtitle("Log in using your biometric credential")
            //.setNegativeButtonText("Use account password")
            .setAllowedAuthenticators(BiometricManager.Authenticators.BIOMETRIC_STRONG or BiometricManager.Authenticators.DEVICE_CREDENTIAL)
            //.setNegativeButtonText("Cancelar")
            .build()
    }

    private fun initObservables() {

        mainViewModel.user.observe(this){
            startActivity(Intent(this, MainActivity2::class.java))
        }

        mainViewModel.error.observe(this){
            Snackbar.make(
                this,
                binding.txtUser,
                it,
                Snackbar.LENGTH_LONG
            ).show()
        }

        mainViewModel.resultCheckBiometric.observe(this) { code ->

            //Itero sobre lo que tengo en mi MainViewModel
            when (code) {
                BiometricManager.BIOMETRIC_SUCCESS -> {
                    binding.imgFinger.visibility = View.VISIBLE
                    binding.textInfo.text = "Presione para autenticarse"
                    Log.d("MY_APP_TAG", "App can authenticate using biometrics.")
                }

                BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE -> {
                    binding.textInfo.text = "No  posee un sensor de huellas"
                    Log.e("MY_APP_TAG", "No biometric features available on this device.")
                }

                BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE -> {
                    Log.e("MY_APP_TAG", "Biometric features are currently unavailable.")
                }

                BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED -> {
                    // Prompts the user to create credentials that your app accepts.
                    val enrollIntent = Intent(Settings.ACTION_BIOMETRIC_ENROLL).apply {
                        putExtra(
                            Settings.EXTRA_BIOMETRIC_AUTHENTICATORS_ALLOWED,
                            BiometricManager.Authenticators.BIOMETRIC_STRONG or BiometricManager.Authenticators.DEVICE_CREDENTIAL
                        )
                    }
                    startActivityForResult(enrollIntent, 100)
                }

            }
        }
    }
}