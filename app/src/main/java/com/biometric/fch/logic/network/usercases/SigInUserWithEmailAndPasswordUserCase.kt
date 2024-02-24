package com.biometric.fch.logic.network.usercases

import com.biometric.fch.data.entities.UserDB
import com.biometric.fch.data.repositories.AutenticatioRepository

class SigInUserWithEmailAndPasswordUserCase {

    suspend fun invoke(email : String, password : String): UserDB?{
        var user: UserDB? = null
        AutenticatioRepository().signInUsers(email,password)
            .onSuccess {
                user = it
            }.onFailure {
                user = null
            }
        return user
    }
}