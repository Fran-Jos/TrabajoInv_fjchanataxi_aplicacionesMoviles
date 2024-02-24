package com.biometric.fch.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.biometric.fch.data.network.entities.frutas.FrutasItem
import com.biometric.fch.logic.network.usercases.frutas.GetALLFrutasKtor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ApiFrutaViewModels: ViewModel() {
    val listItems = MutableLiveData<List<FrutasItem>>()
    val error = MutableLiveData<String>()

    fun getAllFrutas() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = GetALLFrutasKtor().invoke()
            if (response.isNotEmpty()){
                listItems.postValue(response)
            }else error.postValue("Ocurrio un error al llamar a la API")

        }
    }

}