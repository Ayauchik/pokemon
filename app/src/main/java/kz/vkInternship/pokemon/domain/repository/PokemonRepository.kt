package kz.vkInternship.pokemon.domain.repository

import kz.vkInternship.pokemon.domain.model.PokemonDetails
import kz.vkInternship.pokemon.domain.model.PokemonSprite
import kz.vkInternship.pokemon.domain.model.PokemonsModel
import kz.vkInternship.pokemon.domain.model.ability.PokemonAbilityDetails
import kz.vkInternship.pokemon.domain.model.location.PokemonLocations

interface PokemonRepository {
    suspend fun getPokemons(offset: Int = 0, limit: Int = 20): PokemonsModel
    suspend fun getSpritesOfPokemonByIdOrName(idOrName: Any): PokemonSprite

    suspend fun getPokemonDetails(name: String): PokemonDetails

    suspend fun getAbilityDetails(name: String): PokemonAbilityDetails

    suspend fun getPokemonLocations(name: String): PokemonLocations
}