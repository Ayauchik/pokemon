package kz.vkInternship.pokemon.domain.use_cases

import kz.vkInternship.pokemon.domain.model.PokemonSprite

interface GetSpritesOfPokemonByIdOrName {
    suspend fun invoke(idOrName: Any): PokemonSprite
}