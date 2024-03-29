package com.biometric.fch.data.network.entities.bebidas

import kotlinx.serialization.Serializable

@Serializable
data class Drink(
    val dateModified: String? = "",
    val idDrink: String? = "",
    val strAlcoholic: String? = "",
    val strCategory: String? = "",
    val strCreativeCommonsConfirmed: String? = "",
    val strDrink: String? = "",
    val strDrinkThumb: String? = "",
    val strGlass: String? = "",
    val strIBA: String? = "",
    val strImageAttribution: String? = "",
    val strImageSource: String? = "",
    val strIngredient1: String? = "",
    val strIngredient2: String? = "",
    val strIngredient3: String? = "",
    val strIngredient4: String? = "",
    val strIngredient5: String? = "",
    val strIngredient6: String? = "",
    val strInstructions: String? = "",
    val strInstructionsDE: String? = "",
    val strInstructionsES: String? = "",
    val strInstructionsIT: String? = "",
    val strMeasure1: String? = "",
    val strMeasure2: String? = "",
    val strMeasure3: String? = "",
    val strMeasure4: String? = "",
    val strMeasure5: String? = "",
    val strMeasure6: String? = "",
    val strTags: String? = "",
    val strVideo: String? = ""
)