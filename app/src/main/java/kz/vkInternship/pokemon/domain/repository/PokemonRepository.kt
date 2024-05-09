package kz.vkInternship.pokemon.domain.repository

import kz.vkInternship.pokemon.domain.model.PokemonSprite
import kz.vkInternship.pokemon.domain.model.PokemonsModel

interface PokemonRepository {
    suspend fun getPokemons(): PokemonsModel
    suspend fun getSpritesOfPokemonByIdOrName(idOrName: Any): PokemonSprite
}