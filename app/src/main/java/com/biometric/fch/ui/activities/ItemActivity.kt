package com.biometric.fch.ui.activities

import android.os.Binder
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.biometric.fch.R
import com.biometric.fch.data.network.endpoints.APIService
import com.biometric.fch.databinding.ActivityItemBinding
import com.biometric.fch.ui.adapters.DogAdapter
import com.biometric.fch.ui.viewmodels.ApiBebidaViewModels
import com.biometric.fch.ui.viewmodels.DogViewHolder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ItemActivity : AppCompatActivity(), OnQueryTextListener {

    private lateinit var binding: ActivityItemBinding
    private lateinit var adapter: DogAdapter
    private val dogImages = mutableListOf<String>()
    private val viewModel: DogViewHolder
        get() {
            TODO()
        }
    private lateinit var dialog: AlertDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItemBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.svDogs.setOnQueryTextListener(this)
        initRecyclerView()

        dialog = AlertDialog.Builder(this)
            .setMessage(getString(R.string.carga_datos2))
            .setTitle(getString(R.string.title_dialog))
            .setPositiveButton(getString(R.string.aceptar)) { _, _ ->

            }
            .setNegativeButton(getString(R.string.cancelar)) { dialog, _ ->
                dialog.dismiss()
            }
            .setCancelable(false)
            .create()

        dialog.show()
    }



    //RecyclerView
    private fun initRecyclerView() {
        adapter = DogAdapter(dogImages)
        binding.rvDogs.layoutManager = LinearLayoutManager(this)
        binding.rvDogs.adapter = adapter
    }


    //RetroFit
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breed/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    //Corrutina
    private fun searchByName(query:String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIService::class.java).getDogsByBreeds("$query/images")
            val puppies = call.body()
            runOnUiThread {
                if(call.isSuccessful){
                    val images = puppies?.images ?: emptyList()
                    dogImages.clear()
                    dogImages.addAll(images)
                    adapter.notifyDataSetChanged()
                }else{
                    showError()
                }
            }
        }
    }
    private fun showError() {
        Toast.makeText(this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if(!query.isNullOrEmpty()){
            searchByName(query.toLowerCase())
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }
}

