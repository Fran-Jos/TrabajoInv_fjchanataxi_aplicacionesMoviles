package com.biometric.fch.logic.network.usercases.frutas

import android.util.Log
import com.biometric.fch.data.network.entities.frutas.Frutas
import com.biometric.fch.data.network.entities.frutas.FrutasItem
import com.biometric.fch.data.network.repositories.KtorApiModule
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.http.isSuccess

class GetALLFrutasKtor {
    suspend fun invoke(): List<FrutasItem>{
        var ret : List<FrutasItem> = ArrayList()
        runCatching {
            //este es de mi endpoind
            KtorApiModule.getKtorHttpClient().get{
                url(KtorApiModule.FRUTAS+"all")
            }
        }.onSuccess {
            if (it.status.isSuccess()){
                ret= it.body<Frutas>().frutas!!
            }
        }.onFailure {
            Log.d("TAG",it.message.toString())
        }
        return ret

    }
}