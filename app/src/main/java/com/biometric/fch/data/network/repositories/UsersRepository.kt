package com.biometric.fch.data.repositories

import com.biometric.fch.data.entities.UserDB
import com.google.firebase.Firebase
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.tasks.await

class UsersRepository {

    private val  db = Firebase.firestore

    suspend fun saveUserDB(id: String, email : String, name : String , nickname : String):Result<UserDB> = runCatching{

        val us = UserDB(id,email,name,nickname)

        db.collection("Users").add(us).await()
        return@runCatching us
    }

    suspend fun  getUserByID(id:String)= runCatching{

        val us = UserDB(id,"","","")
        return@runCatching  db.collection("Users")
            .document(us.id)
            .get()
            .await<DocumentSnapshot?>()?.toObject<UserDB>(UserDB::class.java)
    }

    suspend fun  updateUserByID(id:String)= runCatching{

        val us = UserDB(id,"","","")
        val v = db.collection("Users")
            .document(us.id)
            .get()
            .await<DocumentSnapshot?>()?.toObject<UserDB>(UserDB::class.java)

        if (v != null){
            v!!.email="emailNo"
            db.collection("Users").document(v!!.id).set(v)
        }

    }

    suspend fun deleteUserByID(id: String): ResultadoEliminacion {
        return runCatching {
            val user = getUserByID(id)  // Intenta obtener el usuario por ID
            if (user.isSuccess) {
                val documentReference = db.collection("Users").document(user.getOrNull()!!.id)
                documentReference.delete().await()
                ResultadoEliminacion.Exito
            } else {
                ResultadoEliminacion.Error("Usuario no encontrado")
            }
        }.getOrDefault(ResultadoEliminacion.Error("Error desconocido"))
    }

    sealed class ResultadoEliminacion {
        object Exito : ResultadoEliminacion()
        data class Error(val mensaje: String) : ResultadoEliminacion()
    }

}