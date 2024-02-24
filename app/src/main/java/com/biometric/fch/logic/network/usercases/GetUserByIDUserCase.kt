package com.biometric.fch.logic.network.usercases

import com.biometric.fch.data.entities.UserDB
import com.biometric.fch.data.repositories.UsersRepository

class GetUserByIDUserCase {

    suspend fun invoke(id:String): UserDB?{
        return UsersRepository().getUserByID(id).getOrNull()
    }
}