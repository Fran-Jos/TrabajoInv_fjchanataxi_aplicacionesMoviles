package com.biometric.fch.logic.network.usercases.bebidas

import android.util.Log
import com.biometric.fch.data.network.entities.bebidas.Drink
import com.biometric.fch.data.network.entities.bebidas.Fbebidas
import com.biometric.fch.data.network.entities.frutas.Frutas
import com.biometric.fch.data.network.entities.frutas.FrutasItem
import com.biometric.fch.data.network.repositories.KtorApiModule
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.http.isSuccess

class GetALLBebidasKtor {
    suspend fun invoke(): List<Drink>{
        var ret : List<Drink> = ArrayList()
        runCatching {

            KtorApiModule.getKtorHttpClient().get{
                url("www.thecocktaildb.com/api/json/v1/1/search.php?f=a")
            }
        }.onSuccess {
            if (it.status.isSuccess()){
                ret= it.body<Fbebidas>().drinks!!
            }
        }.onFailure {
            Log.d("TAG",it.message.toString())
        }
        return ret

    }
}