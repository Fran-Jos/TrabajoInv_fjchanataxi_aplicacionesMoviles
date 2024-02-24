package com.biometric.fch.logic.network.usercases

import com.biometric.fch.data.entities.UserDB
import com.biometric.fch.data.repositories.UsersRepository

class SaveUserInDBUserCase {
    suspend fun  invoke(id:String, email:String , name: String , number : String): UserDB? {
        return UsersRepository().saveUserDB(id, email, name, number).getOrNull()

    }
}