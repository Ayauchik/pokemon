package kz.vkInternship.pokemon.data.network.response.generation

import kz.vkInternship.pokemon.data.network.response.material.Crystal
import kz.vkInternship.pokemon.data.network.response.material.Gold
import kz.vkInternship.pokemon.data.network.response.material.Silver

data class GenerationIi(
    val crystal: Crystal,
    val gold: Gold,
    val silver: Silver
)