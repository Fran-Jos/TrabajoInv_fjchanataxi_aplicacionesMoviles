package com.biometric.fch.data.network.entities.bebidas

import kotlinx.serialization.Serializable

@Serializable
data class Fbebidas(
    val drinks: List<Drink>?= emptyList()
)