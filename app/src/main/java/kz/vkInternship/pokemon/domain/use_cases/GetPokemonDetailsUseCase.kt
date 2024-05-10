package kz.vkInternship.pokemon.domain.use_cases

import kz.vkInternship.pokemon.domain.model.PokemonDetails

interface GetPokemonDetailsUseCase {
    suspend fun invoke(name:String): PokemonDetails
}