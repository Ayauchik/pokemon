package kz.vkInternship.pokemon.data.network.response.material

import kz.vkInternship.pokemon.data.network.response.Animated

data class BlackWhite(
    val animated: Animated,
    val back_default: String,
    val back_female: String,
    val back_shiny: String,
    val back_shiny_female: String,
    val front_default: String,
    val front_female: String,
    val front_shiny: String,
    val front_shiny_female: String
)