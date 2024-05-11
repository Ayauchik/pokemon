package kz.vkInternship.pokemon.data.network.response

import kz.vkInternship.pokemon.data.network.response.material.DreamWorld
import kz.vkInternship.pokemon.data.network.response.material.Home
import kz.vkInternship.pokemon.data.network.response.material.OfficialArtwork
import kz.vkInternship.pokemon.data.network.response.material.Showdown

data class Other(
    val dream_world: DreamWorld,
    val home: Home,
    val official_artwork: OfficialArtwork,
    val showdown: Showdown
)