package com.biometric.fch.data.network.entities.frutas

import kotlinx.serialization.Serializable

@Serializable
data class Frutas(

    val frutas: List<FrutasItem>?= emptyList()
)