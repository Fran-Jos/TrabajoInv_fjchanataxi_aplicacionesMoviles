package com.biometric.fch.data.entities

data class UserDB(val id: String,
                  var email: String,
                  // agregamos un nuevo dato
                  val name: String,
                  val number : String
)
