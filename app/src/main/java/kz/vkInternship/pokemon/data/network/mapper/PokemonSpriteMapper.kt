package kz.vkInternship.pokemon.data.network.mapper

import kz.vkInternship.pokemon.data.network.response.GetSprites
import kz.vkInternship.pokemon.domain.model.PokemonSprite

class PokemonSpriteMapper(
    private val spritesMapper: SpritesMapper
) {
    fun fromRemoteToDomain(getSprites: GetSprites): PokemonSprite {
        return PokemonSprite(
            id = getSprites.id,
            name = getSprites.name,
            sprites = spritesMapper.fromRemoteToDomain(getSprites.sprites)
        )
    }
}