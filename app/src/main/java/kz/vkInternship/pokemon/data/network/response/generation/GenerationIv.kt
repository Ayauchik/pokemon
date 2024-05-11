package kz.vkInternship.pokemon.data.network.response.generation

import kz.vkInternship.pokemon.data.network.response.material.DiamondPearl
import kz.vkInternship.pokemon.data.network.response.material.HeartgoldSoulsilver
import kz.vkInternship.pokemon.data.network.response.material.Platinum

data class GenerationIv(
    val diamondpearl: DiamondPearl,
    val heartgoldsoulsilver: HeartgoldSoulsilver,
    val platinum: Platinum
)