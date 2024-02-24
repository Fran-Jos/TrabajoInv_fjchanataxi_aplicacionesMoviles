package com.biometric.fch.data.network.entities.frutas

import kotlinx.serialization.Serializable

@Serializable
data class Nutritions(
    val calories: Int?=0,
    val carbohydrates: Double?=0.0,
    val fat: Double?=0.0,
    val protein: Double?=0.0,
    val sugar: Double?=0.0
)