package com.biometric.fch.data.network.entities.frutas

import kotlinx.serialization.Serializable

@Serializable
data class FrutasItem(
    val family: String?="",
    val genus: String?="",
    val id: Int?=0,
    val name: String?="",
    val nutritions: Nutritions?=null,
    val order: String?=""
)