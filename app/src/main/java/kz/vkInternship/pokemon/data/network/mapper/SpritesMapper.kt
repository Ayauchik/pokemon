package kz.vkInternship.pokemon.data.network.mapper

import kz.vkInternship.pokemon.data.network.response.Sprites

class SpritesMapper {
    fun fromRemoteToDomain(sprites: Sprites): kz.vkInternship.pokemon.domain.model.Sprites{
        return kz.vkInternship.pokemon.domain.model.Sprites(
            back_default = sprites.back_default,
            back_female = sprites.back_female,
            back_shiny = sprites.back_shiny,
            back_shiny_female = sprites.back_shiny_female,
            front_default = sprites.front_default,
            front_female = sprites.front_female,
            front_shiny = sprites.front_shiny,
            front_shiny_female = sprites.front_shiny_female
        )
    }
}